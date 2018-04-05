package com.zxg.datastructure.Tree.avltree;

import com.zxg.datastructure.Tree.binarysearchtree.BinarySearchTree;

/**
 * 平衡二叉查找树：继承于二叉树，根据其独特属性重写insert、delete等方法
 * @param <T>
 */
public class AVLTree<T extends Comparable> extends BinarySearchTree<T>{


    public AVLTree(T[] pList, T[] inList, int flag) {
        super(pList, inList, flag);
    }

    @Override
    public void insert(T data) {
        if (data == null) {
            throw new RuntimeException("data can not be null");
        }
        root = insert(data, (AVLNode<T>) root);
    }

    private AVLNode<T> insert(T data, AVLNode<T> node) {
        if (node == null) {
            return new AVLNode<T>(data);
        }
        int compareResult = data.compareTo(node.data);
        if (compareResult > 0) {
            node.right = insert(data, (AVLNode<T>) node.right);
            //插入操作结束后，递归往回走时，一层一层计算插入后的高度差，由于最终插入到右子树
            //所以右子树高度必定大于左子树。此时node为失衡点
            if (height(node.right) - height(node.left) == 2) {
                //判断data插入的是node.right的左边还是右边，这里是子树与父树的值比较
                if (data.compareTo(node.right.data) > 0) {
                    node = singleRotateRight(node);
                } else {
                    node = doubleRotateWithLeft(node);
                }
            }
        } else if (compareResult < 0) {
            node.left = insert(data, (AVLNode<T>) node.left);
            if (height(node.left) - height(node.right) == 2) {
                if (data.compareTo(node.left) < 0) {
                    node = singleRotateLeft(node);
                } else {
                    node = doubleRotateWithRight(node);
                }
            }
        }
        return node;
    }
    
    @Override
    public void delete(T data) {

    }
    /**
     * 方法名中的方向并不是往哪个方向转，而是代表哪颗子树高度需要调整
     *       10          9
     *      /           / \
     *     9   ->      8  10
     *    /
     *   8
     * @param originalNode
     * @return
     */
    private AVLNode<T> singleRotateLeft(AVLNode<T> originalNode) {
        AVLNode<T> targetNode = (AVLNode<T>) originalNode.left;
        /**
         * 这步在实际情况中其实用不到，节点9在实际情况中不会有左右两颗子树
         * 因为当9有一颗子树时已经为不平衡状态，此时就应该旋转了。
         */
        originalNode.left = targetNode.right;
        targetNode.right = originalNode;
        targetNode.height = Math.max(height(targetNode.left), height(targetNode.right)) + 1;
        originalNode.height = Math.max(height(originalNode.left), height(originalNode.right)) + 1;
        return targetNode;


    }

    /**
     *       10            11
     *        \           / \
     *        11  ->     10 12
     *         \
     *         12
     * @param originalNode
     * @return
     */
    private AVLNode<T> singleRotateRight(AVLNode<T> originalNode) {
        AVLNode<T> targetNode = (AVLNode<T>) originalNode.right;
        originalNode.right = targetNode.left;
        targetNode.left = originalNode;
        targetNode.height = Math.max(height(targetNode.left), height(targetNode.right)) + 1;
        originalNode.height = Math.max(height(originalNode.left), height(originalNode.right)) + 1;
        return targetNode;
    }


    /**
     *       10          10          9
     *      /           /           / \
     *     8     ->    9      ->   8  10
     *      \         /
     *       9       8
     * @param originalNode
     * @return
     */
    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> originalNode) {
        originalNode.left = singleRotateRight((AVLNode<T>) originalNode.left);
        return singleRotateRight(originalNode);
    }

    /**
     *    10          10             12
     *     \           \            /  \
     *     13  ->      12    ->    10  13
     *    /             \
     *   12             13
     * @param originalNode
     * @return
     */
    private AVLNode<T> doubleRotateWithRight(AVLNode<T> originalNode) {
        originalNode.right = singleRotateLeft((AVLNode<T>) originalNode.right);
        return singleRotateLeft(originalNode);
    }

    private int height(AVLNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            int l = height(node.left);
            int r = height(node.right);
            return l > r ? (l + 1) : (r + 1);
        }

    }
}
