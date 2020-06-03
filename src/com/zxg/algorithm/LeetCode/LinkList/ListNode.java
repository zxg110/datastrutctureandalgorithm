package com.zxg.algorithm.LeetCode.LinkList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    
    public static ListNode getListNode(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;

        l3.next = l5;
        l5.next = l6;
        return l1;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static String getListStr(ListNode head){
        String str = "";
        while (head != null){
            str = str+ head.val+"->";
            head = head.next;
        }
        return str.substring(0,str.length()-2);
    }

    @Override
    public String toString() {
        return val+"";
    }
}
