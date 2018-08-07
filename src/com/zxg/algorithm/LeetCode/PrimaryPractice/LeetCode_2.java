package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.List;

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
        if (number == 0) {
            return new ListNode(0);
        }
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
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        ListNode node_4 = new ListNode(9);
        ListNode node_5 = new ListNode(9);
        ListNode node_6 = new ListNode(9);
        node3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;
        LeetCode_2 leetCode_2 = new LeetCode_2();
        ListNode result = leetCode_2.addTwoNumbers(node1, node2);
        System.out.println(result.toString());
    }

}
