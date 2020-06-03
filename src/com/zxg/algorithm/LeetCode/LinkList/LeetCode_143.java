package com.zxg.algorithm.LeetCode.LinkList;

import java.util.List;

/**
 * 重排链表
 * L0->L1->L2...Ln
 * L0->Ln->L1->Ln-1->L2->Ln-2...
 * 1->2->3->4  =>  1->4->2->3
 * 1->2->3->4->5 => 1->5->2-4->3
 * <p>
 * 思路：找到中间节点，将后半部分链表反转变成1->2;5->4->3 然后各链表取一个组成新链表
 * 感悟：复杂题，其思路之一将链表基础操作如反转、找到中间节点等组合起来使用
 */
public class LeetCode_143 {


    public void reorderList(ListNode head) {
        //找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        reverseList(slow);
        int middleVal = slow.val;

        ListNode firstList = head;
        ListNode secondList = result1.next;
        ListNode newNode = new ListNode(0);
        ListNode cur = newNode;
        boolean flag = true;
        while ((secondList != null && secondList.next != null) || flag) {
            cur.next = new ListNode(firstList.val);
            cur = cur.next;
            cur.next = new ListNode(secondList.val);
            cur = cur.next;
            firstList = firstList.next;
            secondList = secondList.next;
            if (firstList.val == middleVal) {
                flag = false;
                if(secondList!=null){
                    cur.next = new ListNode(secondList.val);
                    cur = cur.next;
                }

            }
        }
        head = newNode.next;
        ListNode.printList(head);
    }

    ListNode result = new ListNode(0);
    ListNode result1 = result;

    public void reverseList(ListNode head) {
        if (head.next != null) {
            reverseList(head.next);
        }
        result.next = new ListNode(head.val);
        result = result.next;
    }

    public static void main(String[] args) {
        LeetCode_143 leetCode_143 = new LeetCode_143();
        leetCode_143.reorderList(ListNode.getListNode());
    }

}
