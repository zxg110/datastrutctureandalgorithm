package com.zxg.algorithm.LeetCode.LinkList;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_83 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode listNode = head;
        Set<Integer> set = new HashSet<>();
        set.add(listNode.val);
        while (listNode != null && listNode.next != null) {
            if (!set.add(listNode.next.val)) {
                listNode.next = listNode.next.next;
            } else {
                listNode = listNode.next;
            }

        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        head.next = deleteDuplicates2(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new LeetCode_83.ListNode(1);
        ListNode l2 = new LeetCode_83.ListNode(2);
        ListNode l3 = new LeetCode_83.ListNode(3);
        ListNode l4 = new LeetCode_83.ListNode(3);
        ListNode l5 = new LeetCode_83.ListNode(4);
        ListNode l6 = new LeetCode_83.ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        LeetCode_83.printList(deleteDuplicates2(l1));
    }
}
