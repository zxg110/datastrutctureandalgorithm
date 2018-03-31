package com.zxg.datastructure.Tree.base;

import java.util.List;

/**
 * Created by zengxiangge on 2018-3-14.
 */

public interface Tree<T extends Comparable> {
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
    List<T> inOrder();

    /**
     * 后根次序遍历
     * @return
     */
    List<T> postOrder();

    /**
     * 层次遍历
     */
    List<T> levelOrder();

    void insert(T data);

    void delete(T data);

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
