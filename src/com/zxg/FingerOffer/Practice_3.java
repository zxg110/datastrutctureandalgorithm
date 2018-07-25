package com.zxg.FingerOffer;

/**
 * 根据前序遍历和中序遍历重建二叉树
 */
public class Practice_3 {
    public static void main(String[] args) {
        int[] preList = {1,2,4,5,3};
        int[] inList = {4,2,5,1,3};
        Node root = createBinaryTreeByPreAndIn(preList, inList, 0, preList.length - 1, 0, inList.length-1);
        System.out.println(root.toString());
    }

    public static Node createBinaryTreeByPreAndIn(int[] preList, int[] inList, int preStart, int preEnd, int inStart, int inEnd) {
        Node node = new Node(preList[preStart]);
        if (preStart == preEnd && inStart == inEnd) {
            return node;
        }
        int inListRootIndex = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inList[i] == preList[preStart]) {
                inListRootIndex = i;
                break;
            }
        }
        //左子树长度
        int leftLen = inListRootIndex - inStart;
        //右子树长度
        int rightLen = inEnd - inListRootIndex;
        //根据左右子树长度可以计算出在先序遍历中左右子树的始末下标
        if (leftLen > 0) {
            //左子树先序遍历始末下标：preList[preStart+1](父节点下标+1)...preList[preStart+leftLen](父节点下标加左子树长度)
            //左子树中序遍历始末下标：inList[inStart]（中序遍历数组起始下标）...inList[inListRootIndex-1](根节点下标-1)
            node.left = createBinaryTreeByPreAndIn(preList, inList, preStart + 1, preStart + leftLen, inStart, inListRootIndex - 1);
        }
        if (rightLen > 0) {
            //右子树先序遍历始末下标：preList[preStart+leftLen+1](左子树末下标+1)...preList[preEnd](先序遍历末下标)
            //右子树中序遍历始末下标：inList[inListRootIndex+1](根节点下标+1)...inList[inEnd](中序遍历末下标)
            node.right = createBinaryTreeByPreAndIn(preList, inList, preStart + leftLen + 1, preEnd, inListRootIndex + 1, inEnd);
        }
        return node;

    }

    static class Node {
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "left:" + left.value + ",right:" + right.value;
        }
    }
}
