package com.zxg.algorithm.LeetCode.LinkList;

//实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
public class LeetCode_xx {
    //Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int kthToLast(ListNode head, int k) {
        ListNode firstNode = head;
        ListNode secondNode = head;
        for (int i = 0; i < k; i++) {
            firstNode = firstNode.next;
        }
        System.out.println("first value" + firstNode.val);
        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return secondNode.val;
    }

    public static void main(String[] args) {
        ListNode l1 = new LeetCode_xx.ListNode(1);
        ListNode l2 = new LeetCode_xx.ListNode(2);
        ListNode l3 = new LeetCode_xx.ListNode(3);
        ListNode l4 = new LeetCode_xx.ListNode(4);
        ListNode l5 = new LeetCode_xx.ListNode(5);
        ListNode l6 = new LeetCode_xx.ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println(LeetCode_xx.kthToLast(l1, 2));
    }
}
