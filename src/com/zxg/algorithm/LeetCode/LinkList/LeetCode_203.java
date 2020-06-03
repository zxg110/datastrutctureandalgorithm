package com.zxg.algorithm.LeetCode.LinkList;

/**
 * 删除指定元素
 */
public class LeetCode_203 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode head1 = head;
        while (head1.next != null) {
            if (head1.next.val == val) {
                head1.next = head1.next.next;
            }else {
                head1 = head1.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new LeetCode_203.ListNode(1);
        ListNode l2 = new LeetCode_203.ListNode(6);
        ListNode l3 = new LeetCode_203.ListNode(3);
        ListNode l4 = new LeetCode_203.ListNode(6);
        ListNode l5 = new LeetCode_203.ListNode(5);
        ListNode l6 = new LeetCode_203.ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        LeetCode_203.printList(LeetCode_203.removeElements(l1, 6));

    }
}
