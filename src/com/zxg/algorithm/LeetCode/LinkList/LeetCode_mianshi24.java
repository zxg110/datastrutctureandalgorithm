package com.zxg.algorithm.LeetCode.LinkList;

/**
 * 反转链表
 */
public class LeetCode_mianshi24 {
    public ListNode result = new ListNode(0);
    public ListNode result1 = result;

    public  void reverseList(ListNode head){
        if(head.next != null){
            reverseList(head.next);
        }
        result.next = new ListNode(head.val);
        result = result.next;
        System.out.println(result1);
    }

    public void reverseList1(ListNode head){
        ListNode next = null;
        ListNode pre = null;
        while(head != null){
            //先存当前节点的next节点
            next = head.next;
            //当前节点的next节点指向前节点
            head.next = pre;
            //前节点指向当前节点
            pre = head;
            //当前节点往前移
            head = next;
        }
    }

    public static void main(String[] args) {
        LeetCode_mianshi24 leetCode_mianshi24 = new LeetCode_mianshi24();
        leetCode_mianshi24.reverseList(ListNode.getListNode());
        ListNode r1 = leetCode_mianshi24.result1;
        ListNode.printList(r1);
    }


}
