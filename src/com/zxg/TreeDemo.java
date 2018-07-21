package com.zxg;

import com.zxg.datastructure.Tree.base.BinaryNode;

public class TreeDemo {
    public static int maxLen;
    public static void main(String[] args) {

        Node root = new Node("root");
        root.left = new Node("left");
        root.right = new Node("right");
        root.right.right = new Node("2");
        root.right.right.right = new Node("3");
        root.right.right.right.right = new Node("4");
        root.left.left = new Node("left1");
//        root.left.right = new Node("right1");
//        root.left.right.right = new Node("right2");
//        root.left.right.right.right = new Node("right3");
//        root.left.left.left = new Node("left2");
        maxLength(root);
//        System.out.println("maxLen:"+maxLen);
        System.out.println("maxSize:"+maxSize(root));

    }

    /**
     *
     * @param node
     * @return
     */
    public static int maxLength(Node node){
        if(node == null){
            return 0;
        }
        int leftHigh = maxLength(node.left);
        int rightHigh = maxLength(node.right);
        int rootHigh = Math.max(leftHigh,rightHigh)+1;
        if(leftHigh+rightHigh>maxLen){
            maxLen = leftHigh+rightHigh;
        }
        return rootHigh;
    }

    public static int maxSize(Node root){
        int left = size(root.left);
        int right = size(root.right);
        return Math.max(left,right);

    }
    public static int size(Node subtree) {
        if (subtree == null)
            return 0;
        else {
            return size( subtree.left) + 1 + size(subtree.right);
        }
    }
}
class Node {
    public Node left;
    public Node right;
    public String value;
    public int size =1;
    Node(String value){
        this.value = value;
    }
}