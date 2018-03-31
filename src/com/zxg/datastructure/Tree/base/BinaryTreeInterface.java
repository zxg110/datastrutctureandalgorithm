package com.zxg.datastructure.Tree.base;

import java.util.List;

public interface BinaryTreeInterface<T extends Comparable>{
    boolean isEmpty();

    int size();

    int height();

    /**
     * 先根次序遍历
     * @return
     */
    List<T> preOrder();

    /**
     * 中根次序遍历
     * @return
     */
    List<T>  inOrder();

    /**
     * 后根次序遍历
     * @return
     */
    List<T>  postOrder();

    /**
     * 层次遍历
     */
    List<T>  levelOrder();



    T findMin();

    T findMax();

    /**
     * 根据值找到结点
     * @param data
     * @return
     */
    BinaryNode findNode(T data);

    /**
     * 是否包含某个值
     * @param data
     * @return
     */
    boolean contains(T data) ;

    /**
     * 清空
     */
    void clear();
}
