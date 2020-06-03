package com.zxg.algorithm.LeetCode.LinkList;

import java.util.List;

//单链表进行插入排序
public class LeetCode_147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = new ListNode(head.val);
        ListNode sorted = new ListNode(head.val);
        ListNode cur = head.next;
        while (cur != null){
            sorted = insert(sorted,new ListNode(cur.val));
            cur = cur.next;
        }
        return sorted;
    }

    public ListNode insert(ListNode head,ListNode targetNode) {
        System.out.println("head:"+ListNode.getListStr(head)+"target:"+targetNode.val);
        if(head.val >= targetNode.val){
            targetNode.next = head;
            return targetNode;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= targetNode.val) {

                pre.next = targetNode;
                targetNode.next = cur;
                break;
            }
            pre = cur;
            cur = cur.next;
            //已经遍历到队尾了 还没有比目标值大的
            if(cur == null){
                pre.next = targetNode;
            }

        }
        System.out.println("result---->"+ListNode.getListStr(head));

        return head;
    }

    public static void main(String[] args) {
        LeetCode_147 leetCode_147 = new LeetCode_147();
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println("original:"+ListNode.getListStr(l1));
        System.out.println("final result:"+ListNode.getListStr(leetCode_147.insertionSortList(l1)));


    }

}
