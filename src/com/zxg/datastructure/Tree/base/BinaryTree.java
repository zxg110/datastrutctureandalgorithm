package com.zxg.datastructure.Tree.base;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by zengxiangge on 2018-3-14.
 */

public class BinaryTree<T extends Comparable> implements BinaryTreeInterface<T> {
    private BinaryNode<T> root = null;

    public BinaryTree(T data) {
        root = new BinaryNode<>(data);
    }

    /**
     * 保存level遍历的所有节点数据，用于使用list api
     * 实现findMin/findMax等方法
     */
    private List<T> nodeDataList;

    public BinaryTree(){

    }

    public BinaryTree(BinaryNode<T> node){
        root = node;
    }
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node<T> subtree) {
        if (subtree == null)
            return 0;
        else {
            return size((BinaryNode<T>) subtree.left) + 1 + size((BinaryNode<T>) subtree.right);
        }
    }

    @Override
    public int height() {
        return height(root);
    }

    /**
     * 先根遍历
     *
     * @return
     */
    @Override
    public List<T> preOrder() {
        return preOrder(root);
    }

    private List<T> preOrder(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<>();
        if (node != null) {
            nodeDataList.add(node.data);
            nodeDataList.addAll(preOrder((BinaryNode<T>) node.left));
            nodeDataList.addAll(preOrder((BinaryNode<T>) node.right));
        }
        return nodeDataList;
    }

    private List<T> preOrderWithStack(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<T>();
        Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                nodeDataList.add(node.data);
                stack.push(node);
                node = (BinaryNode<T>) node.left;
            } else {
                node = stack.pop();
                node = (BinaryNode<T>) node.right;
            }
        }
        return nodeDataList;
    }

    @Override
    public List<T> inOrder() {
        return inOrder(root);
    }

    private List<T> inOrder(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<>();
        if (node != null) {
            nodeDataList.addAll(preOrder((BinaryNode<T>) node.left));
            nodeDataList.add(node.data);
            nodeDataList.addAll(preOrder((BinaryNode<T>) node.right));
        }
        return nodeDataList;
    }

    private List<T> inOrderWithStack(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<T>();
        Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = (BinaryNode<T>) node.left;
            }
            if (!stack.empty()) {
                stack.pop();
                nodeDataList.add(node.data);
                stack.push((BinaryNode) node.right);
            }
        }
        return nodeDataList;
    }


    @Override
    public List<T> postOrder() {
        return postOrder(root);
    }

    private List<T> postOrder(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<>();
        if (node != null) {
            nodeDataList.addAll(preOrder((BinaryNode<T>) node.left));
            nodeDataList.addAll(preOrder((BinaryNode<T>) node.right));
            nodeDataList.add(node.data);
        }
        return nodeDataList;
    }

    private List<T> postOrderWithStack(BinaryNode<T> node) {
        List<T> nodeDataList = new ArrayList<T>();
        //构建用于存放结点的栈
        Stack<BinaryNode<T>> stack = new Stack<>();

        BinaryNode<T> currentNode = this.root;
        BinaryNode<T> prev = this.root;

        while (currentNode != null || !stack.isEmpty()) {
            //把左子树加入栈中,直到叶子结点为止
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = (BinaryNode<T>) currentNode.left;
            }

            //开始访问当前结点父结点的右孩子
            if (!stack.isEmpty()) {
                //获取右孩子，先不弹出
                BinaryNode<T> temp = (BinaryNode<T>) stack.peek().right;
                //先判断是否有右孩子或者右孩子是否已被访问过
                if (temp == null || temp == prev) {//没有右孩子||右孩子已被访问过
                    //如果没有右孩子或者右孩子已被访问,则弹出父结点并访问
                    currentNode = stack.pop();
                    //访问
                    nodeDataList.add(currentNode.data);
                    //记录已访问过的结点
                    prev = currentNode;
                    //置空当前结点
                    currentNode = null;
                } else {
                    //有右孩子,则开始遍历右子树
                    currentNode = temp;
                }
            }

        }
        return nodeDataList;
    }

    @Override
    public List<T> levelOrder() {
        return levelOrderWithQueue(root);
    }

    private List<T> levelOrderWithQueue(BinaryNode<T> node) {
        Queue<BinaryNode<T>> nodeQueue = new LinkedTransferQueue<BinaryNode<T>>();
        List<T> nodeDataList = new ArrayList<T>();
        while (node != null) {
            nodeDataList.add(node.data);
            if (node.left != null) {
                nodeQueue.add((BinaryNode<T>) node.left);
            }
            if (node.right != null) {
                nodeQueue.add((BinaryNode<T>) node.right);
            }
            node = nodeQueue.poll();
        }
        return nodeDataList;
    }

    @Override
    public T findMin() {
        return Collections.min(getNodeDataList(),new DataComparator());
    }

    @Override
    public T findMax() {
        return Collections.max(getNodeDataList(),new DataComparator());
    }

    @Override
    public BinaryNode findNode(T data) {
        Queue<BinaryNode<T>> nodeQueue = new LinkedTransferQueue<BinaryNode<T>>();
        List<T> nodeDataList = new ArrayList<T>();
        BinaryNode<T> node = root;
        while (node != null) {
            if(data.compareTo(node.data) == 0){
                return node;
            }
            if (node.left != null) {
                nodeQueue.add((BinaryNode<T>) node.left);
            }
            if (node.right != null) {
                nodeQueue.add((BinaryNode<T>) node.right);
            }
            node = nodeQueue.poll();
        }
        return null;
    }

    @Override
    public boolean contains(T data) {
        return getNodeDataList().contains(data);
    }

    @Override
    public void clear() {
        root = null;
    }

    public int height(Node subTree) {
        if (subTree == null) {
            return 0;
        } else {
            int i = height(subTree.left);
            int j = height(subTree.right);
            return i < j ? (j + 1) : (i + 1);
        }
    }

    private List<T> getNodeDataList(){
        if(nodeDataList == null || nodeDataList.size() == 0){
            nodeDataList = levelOrder();
        }
        return nodeDataList;
    }

    /**
     * 自定义比较器
     */
    class DataComparator implements Comparator<T>{

        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }
}
