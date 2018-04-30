package com.zxg.datastructure.Tree.binarysearchtree;


import com.zxg.datastructure.Tree.base.BinaryNode;
import com.zxg.datastructure.Tree.base.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zengxiangge on 2018-3-15.
 * 搜索二叉树：对于树的每个结点T（T可能是父结点）,它的左子树中所有项的值小T中的值，
 * 它的右子树中所有项的值都大于T中的值
 */

public class BinarySearchTree<T extends Comparable> extends BinaryTree<T> implements BinarySearchTreeInterface<T>{
    public static final int CREATE_BY_PRE_IN_ORDER = 1;
    public static final int CREATE_BY_POST_IN_ORDER = 2;
    protected BinaryNode<T> root;

    public BinarySearchTree(T[] pList, T[] inList, int flag) {
        if (flag == CREATE_BY_PRE_IN_ORDER) {
            root = createBinarySearchTreeByPreIn(pList, inList,
                    0, pList.length - 1, 0, inList.length - 1);
        } else if (flag == CREATE_BY_POST_IN_ORDER) {
            root = createBinarySearchTreeByPostIn(pList, inList,
                    0, pList.length - 1, 0, inList.length - 1);
        }
    }

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data is null");
        }

    }

    /**
     * 在条件判断中可以直接赋值的原因是，只要输入的node不是null，不会对node做改变，
     * 方法输入的node最终也是方法输出的值，所以在该语句中：node.right = insert(data,node.right);
     * 方法第二个参数与左边是同一node
     *
     * @param data
     * @param node
     * @return
     */
    private BinaryNode<T> insert(T data, BinaryNode node) {
        if (node == null) {
            node = new BinaryNode(data, null, null);
        }
        if (data.compareTo(node.data) == 0) {

        } else if (data.compareTo(node.data) > 0) {
//            if(node.right != null){
//                insert(data,node.right);
//            }else {
//                node.right = new BinaryNode(data);
//            }
            node.right = insert(data, (BinaryNode<T>)node.right);

        } else if (data.compareTo(node.data) < 0) {
//            if(node.left != null){
//                insert(data,node.left);
//            }else {
//                node.left = new BinaryNode(data);
//            }
            node.left = insert(data, (BinaryNode<T>)node.left);
        }
        return node;
    }

    @Override
    public void delete(T data) {
        if(data == null){
            return;
        }
        root = remove(data,root);

    }

    /**
     * 三种情况
     * 1.删除叶子结点(也就是没有孩子结点)
     * 2.删除拥有一个孩子结点的结点(可能是左孩子也可能是右孩子)
     * 3.删除拥有两个孩子结点的结点
     * 有问题 返回数据不对
     * @param p
     * @param data
     */
    private BinaryNode<T> remove(T data, BinaryNode<T> p) {
        //没有找到要删除的元素,递归结束
        if (p == null) {
            return p;
        }
        int compareResult = data.compareTo(p.data);
        if (compareResult < 0) {//左边查找删除结点
            p.left = remove(data, (BinaryNode<T>)p.left);
        } else if (compareResult > 0) {
            p.right = remove(data, (BinaryNode<T>)p.right);
        } else if (p.left != null && p.right != null) {//已找到结点并判断是否有两个子结点(情况3)
            //中继替换，找到右子树中最小的元素并替换需要删除的元素值
            System.out.printf("find data:"+p.data);
            p.data = min((BinaryNode<T>)p.right);
            //移除用于替换的结点
            p.right = remove(p.data, (BinaryNode<T>)p.right);
        } else {
            //拥有一个孩子结点的结点和叶子结点的情况
            p = (p.left != null) ? (BinaryNode<T>)p.left :(BinaryNode<T>) p.right;
        }
        return p;//返回该结点
    }

    public T removeUnrecure(T data){
        if (data==null){
            throw new RuntimeException("data can\'Comparable be null !");
        }
        //从根结点开始查找
        BinaryNode<T> current =this.root;
        //记录父结点
        BinaryNode<T> parent=this.root;
        //判断左右孩子的flag
        boolean isLeft=true;


        //找到要删除的结点
        while (data.compareTo(current.data)!=0){
            //更新父结点记录
            parent=current;
            int result=data.compareTo(current.data);

            if(result<0){//从左子树查找
                isLeft=true;
                current=(BinaryNode<T>)current.left;
            }else if(result>0){//从右子树查找
                isLeft=false;
                current=(BinaryNode<T>)(BinaryNode<T>)current.right;
            }
            //如果没有找到,返回null
            if (current==null){
                return null;
            }
        }

        //----------到这里说明已找到要删除的结点

        //删除的是叶子结点
        if (current.left==null&&current.right==null){
            if (current==this.root){
                this.root=null;
            } else if(isLeft){
                parent.left=null;
            }else {
                parent.right=null;
            }
        }
        //删除带有一个孩子结点的结点,当current的right不为null
        else if (current.left==null){
            if (current==this.root){
                this.root=(BinaryNode<T>)current.right;
            }else if(isLeft){//current为parent的左孩子
                parent.left=current.right;
            }else {//current为parent的右孩子
                parent.right=current.right;
            }
        }
        //删除带有一个孩子结点的结点,当current的left不为null
        else if(current.right==null){
            if (current==this.root){
                this.root=(BinaryNode<T>)current.left;
            }else if (isLeft){//current为parent的左孩子
                parent.left=current.left;
            }else {//current为parent的右孩子
                parent.right=current.left;
            }
        }
        //删除带有两个孩子结点的结点
        else {
            //找到当前要删除结点current的右子树中的最小值元素
            BinaryNode<T> successor= findSuccessor(current);

            if(current == root) {
                this.root = successor;
            } else if(isLeft) {
                parent.left = successor;
            } else{
                parent.right = successor;
            }
            //把当前要删除的结点的左孩子赋值给successor
            successor.left = current.left;
        }
        return current.data;
    }

    /**
     * 查找中继结点--右子树最小值结点
     * @param delNode 要删除的结点
     * @return
     */
    public BinaryNode<T> findSuccessor(BinaryNode<T> delNode) {
        BinaryNode<T> successor = delNode;
        BinaryNode<T> successorParent = delNode;
        BinaryNode<T> current = (BinaryNode<T>)delNode.right;

        //不断查找左结点,直到为空,则successor为最小值结点
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = (BinaryNode<T>)current.left;
        }
        //如果要删除结点的右孩子与successor不相等,则执行如下操作(如果相当,则说明删除结点)
        if(successor != delNode.right) {
            successorParent.left = successor.right;
            //把中继结点的右孩子指向当前要删除结点的右孩子
            successor.right = delNode.right;
        }
        return successor;
    }

    @Override
    public T findMin() {
        if (isEmpty()) {
            return null;
        }
        return min(root);
    }

    private T min(BinaryNode<T> node) {
        if (node.left == null) {
            return node.data;
        } else {
            return min((BinaryNode<T>)node.left);
        }
    }


    @Override
    public T findMax() {
        if (isEmpty()) {
            return null;
        }
        return min(root);
    }

    private T max(BinaryNode<T> node) {
        return node.right == null ? node.data : max((BinaryNode<T>) node.right);
    }

    @Override
    public BinaryNode findNode(T data) {
        return findNode(root, data);
    }

    private BinaryNode findNode(BinaryNode<T> compareNode, T data) {
        if (data.compareTo(compareNode.data) == 0) {
            return compareNode;
        } else if (data.compareTo(compareNode.data) > 0) {
            return findNode((BinaryNode<T>)compareNode.right, data);
        } else {
            return findNode((BinaryNode<T>)compareNode.left, data);
        }
    }

    @Override
    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(BinaryNode<T> compareNode, T data) {
        if (compareNode == null || data == null) {
            return false;
        }
        boolean conains = false;
        if (data.compareTo(compareNode.data) == 0) {
            conains = true;
        } else if (data.compareTo(compareNode.data) > 0) {
            return contains((BinaryNode<T>)compareNode.right, data);
        } else {
            return contains((BinaryNode<T>)compareNode.left, data);
        }
        return conains;
    }

    @Override
    public void clear() {
        root = null;
    }

    private BinaryNode<T> createBinarySearchTreeByPreIn(T[] preList, T[] inList, int preStart,
                                                        int preEnd, int inStart, int inEnd) {
        BinaryNode<T> node = new BinaryNode<T>(preList[preStart]);
        if (preStart == preEnd && inStart == inEnd) {
            return node;
        }
        //找出中序list中root的位置
        int inListRootIndex = 0;
        for (inListRootIndex = inStart; inListRootIndex < inEnd; inListRootIndex++) {
            //如果中根次序中的元素值与先根次序的根结点相当,则该下标index即为inList中的根结点下标
            if (preList[preStart].compareTo(inList[inListRootIndex]) == 0) {
                break;
            }
        }
        int leftLength = inListRootIndex - inStart;
        int rightLength = inEnd - inListRootIndex;

        //递归构建左子树
        if (leftLength > 0) {
            //左子树的先根序列：preList[1] , ... , preList[i]
            //左子树的中根序列：inList[0] , ... , inList[i-1]
            node.left = createBinarySearchTreeByPreIn(preList, inList, preStart + 1, preStart + leftLength, inStart, inListRootIndex - 1);
        }

        //构建右子树
        if (rightLength > 0) {
            //右子树的先根序列：preList[i+1] , ... , preList[n-1]
            //右子树的中根序列：inList[i+1] , ... , inList[n-1]
            node.right = createBinarySearchTreeByPreIn(preList, inList, preStart + leftLength + 1, preEnd, inListRootIndex + 1, inEnd);
        }
        return node;
    }

    private BinaryNode<T> createBinarySearchTreeByPostIn(T[] postList, T[] inList, int postStart,
                                                         int postEnd, int inStart, int inEnd) {
        BinaryNode<T> node = new BinaryNode<T>(postList[postEnd]);
        if (postStart == postEnd && inStart == inEnd) {
            return node;
        }
        //查找中根序列的根结点下标root
        int root = 0;

        for (root = inStart; root < inEnd; root++) {
            //查找到
            if (postList[postEnd].compareTo(inList[root]) == 0) {
                break;
            }
        }

        //左子树的长度
        int leftLenght = root - inStart;
        //右子树的长度
        int rightLenght = inEnd - root;

        //递归构建左子树
        if (leftLenght > 0) {
            //postStart+leftLenght-1:后根左子树的结束下标
            node.left = createBinarySearchTreeByPostIn(postList, inList, postStart, postStart + leftLenght - 1, inStart, root - 1);
        }

        //递归构建右子树
        if (rightLenght > 0) {
            node.right = createBinarySearchTreeByPostIn(postList, inList, postStart + leftLenght, postEnd - 1, root + 1, inEnd);
        }

        return node;
    }

    /**
     * 算法题：
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param node
     * @return
     */
    private BinaryNode<T> treeToDoubleLinkList(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<T>();
        Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = (BinaryNode<T>) node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                stack.push((BinaryNode) node.right);
            }
        }
        return node;
    }
}
