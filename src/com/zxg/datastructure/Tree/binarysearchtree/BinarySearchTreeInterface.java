package com.zxg.datastructure.Tree.binarysearchtree;

import com.zxg.datastructure.Tree.base.BinaryTreeInterface;

public interface BinarySearchTreeInterface<T extends Comparable> extends BinaryTreeInterface<T> {
    void insert(T data);

    void delete(T data);
}
