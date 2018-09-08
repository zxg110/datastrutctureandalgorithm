package com.zxg.algorithm.LeetCode.PrimaryPractice;

public class LeetCode_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针寻找链表中心
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //链表长度为偶数
        if (fast == null) {
            slow = reverse(slow);
        } else {
            slow.next = reverse(slow.next);
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        LeetCode_234 leetCode_234 = new LeetCode_234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(leetCode_234.isPalindrome(head));
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
