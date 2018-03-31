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

    }

    @Override
    public void delete(T data) {

    }
}
