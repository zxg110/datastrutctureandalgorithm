package com.zxg.algorithm.LeetCode.PrimaryPractice;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode_2 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int number_1 = convertToInt(l1);
        int number_2 = convertToInt(l2);
        return convertToNode(number_1 + number_2);
    }

    private int convertToInt(ListNode node) {
        int result = 0;
        int count = 0;
        while (node != null) {
            result = (int) (result + node.val * (Math.pow(10, count)));
            node = node.next;
            count = count + 1;
        }
        return result;
    }

    private ListNode convertToNode(int number) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (number != 0) {
            int remainder = number % 10;
            number = number / 10;
            if (head.val == -1) {
                head.val = remainder;
            } else {
                ListNode node = new ListNode(remainder);
                curNode.next = node;
                curNode = node;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        LeetCode_2 leetCode_2 = new LeetCode_2();
        leetCode_2.addTwoNumbers(node1, node2);
    }

}
