package com.zxg.datastructure.Tree.base;

public class Node<T> {
    public Node<T> left;
    public Node<T> right;

    public T data;

    public Node(Node<T> left, Node<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(T data) {
        this.data = data;
    }

    /**
     * 判断是否为叶子结点
     * @return
     */
    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }

    @Override
    public String toString() {
        return "data:" + data + ",left data is:" + (left == null ? "null" : left.data) +
                "right data is:" + (right == null ? "null" : right.data);
    }
}
