package com.zxg.algorithm;

import java.util.Stack;

/**
 * 算法题：
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class AlgorithmPractice_9 {
    class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode convertNode(TreeNode pNode, TreeNode pLastNodeInList) {
        if (pNode == null) {
            return null;
        }
        TreeNode pCurrent = pNode;
        //递归处理左子树
        if (pCurrent.left != null) {
            pLastNodeInList = convertNode(pCurrent.left, pLastNodeInList);
        }
        //处理当前子树
        //将当前节点的左指针指向已经转换好的链表的最后一个位置
        pCurrent.left = pLastNodeInList;
        //将已经转换好的链表的最后一个节点的右指针指向当前节点
        if (pLastNodeInList != null) {
            pLastNodeInList.right = pCurrent;
        }
        //更新已经转换好的链表的最后一个节点
        pLastNodeInList = pCurrent;

        //递归处理右子树
        if (pCurrent.right != null) {
            pLastNodeInList = convertNode(pCurrent.right, pLastNodeInList);
        }
        return pLastNodeInList;
    }

    private TreeNode convertNodeByStack(TreeNode pNode) {
        TreeNode pLastNodeInList = null;
        TreeNode pCurrent = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (pNode != null || !stack.isEmpty()) {
            while (pNode != null) {
                stack.push(pNode);
                pNode = (TreeNode) pNode.left;
            }
            if (!stack.empty()) {
                pNode = stack.pop();
                pCurrent = pNode;
                //处理当前子树
                //将当前节点的左指针指向已经转换好的链表的最后一个位置
                pCurrent.left = pLastNodeInList;
                //将已经转换好的链表的最后一个节点的右指针指向当前节点
                if (pLastNodeInList != null) {
                    pLastNodeInList.right = pCurrent;
                }
                //更新已经转换好的链表的最后一个节点
                pLastNodeInList = pCurrent;
                pNode = pNode.right;
            }
        }
        return pLastNodeInList;
    }

    public TreeNode convertToLinkList(TreeNode treeRootNode) {
        if (treeRootNode == null) {
            return null;
        }
        TreeNode pLastNodeInList = null;
//        pLastNodeInList = convertNode(treeRootNode, pLastNodeInList);
        pLastNodeInList = convertNodeByStack(treeRootNode);

        TreeNode pHead = pLastNodeInList;
        while (pLastNodeInList != null && pLastNodeInList.left != null) {
            pHead = pLastNodeInList.left;
            pLastNodeInList = pLastNodeInList.left;
        }
        return pHead;
    }

    public static void main(String[] args) {
        AlgorithmPractice_9 father = new AlgorithmPractice_9();
        TreeNode root = father.new TreeNode(9);
        root.left = father.new TreeNode(7);
        root.right = father.new TreeNode(13);
        TreeNode pHead = father.convertToLinkList(root);
        while(pHead != null){
            System.out.printf("=>"+pHead.val);
            pHead = pHead.right;
        }
    }
}
