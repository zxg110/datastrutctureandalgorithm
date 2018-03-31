package com.zxg.datastructure.Tree.base;

import java.io.Serializable;

/**
 * Created by zengxiangge on 2018-3-15.
 *
 */

public class BinaryNode<T extends Comparable> extends Node<T> implements Serializable {

    public BinaryNode(T data,BinaryNode left,BinaryNode right){
        super(left,right,data);
    }

    public BinaryNode(T data){
       super(data);
    }

}
