package com.zxg.algorithm;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengxiangge on 2018-4-20.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class ArithmerticPractice_11 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
    public ListNode deleteDuplication(ListNode head){
        ListNode result = head;
        ListNode temp = head;
        List<Integer> list = new ArrayList<Integer>();
        while(temp != null && temp.next!= null){
            list.add(temp.val);
            if(list.contains(temp.next.val)){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        temp = temp.next;
        if(temp != null && list.contains(temp.val)){
            temp.next = temp.next.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ArithmerticPractice_11 father = new ArithmerticPractice_11();
        ListNode head = father.new ListNode(1);
        ListNode second = father.new ListNode(1);
        ListNode thrid = father.new ListNode(2);
        ListNode fourth = father.new ListNode(2);
        ListNode fifth = father.new ListNode(3);
        head.next = second;
        second.next = thrid;
        thrid.next = fourth;
        fourth.next = fifth;
        printList(head);
        father.deleteDuplication(head);
        printList(head);
    }

    public static void printList(ListNode head){
        while (head!= null){
            System.out.printf("->"+head.val);
            head = head.next;
        }
    }

}
