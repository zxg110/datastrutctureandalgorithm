package com.zxg.datastructure.Tree.avltree;

import com.zxg.datastructure.Tree.base.BinaryNode;

public class AVLNode<T extends Comparable> extends BinaryNode<T>{

    //当前结点高度：AVLTree特有属性
    public int height;

    public AVLNode(T data, AVLNode left, AVLNode right) {
        super(data, left, right);
    }
    public AVLNode(T data){
        super(data);
    }
}
