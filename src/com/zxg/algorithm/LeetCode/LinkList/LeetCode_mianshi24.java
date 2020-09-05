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
        //result每次往前移，所以取result1，result1记录的是result没移动前的节点
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

    public ListNode reverseList2(ListNode head) {
        // 1.递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 递归反转 ⼦子链表
        //newList一直是最后一个节点，回退的每一步就是把指向调头
        //例如 head是5
        //  ListNode t1 = head.next; t1=6
        //t1.next = head 建立6->5
        //head.next = null;  打断5->6
        //接着回退 head=4 建立5->4 打断4->5
        ListNode newList = reverseList2(head.next); // 改变 1，2节点的指向。
        // 通过 head.next获取节点2
        ListNode t1 = head.next;
        // 让 2 的 next 指向 2
        t1.next = head;
        // 1 的 next 指向 null.
        head.next = null;
        // 把调整之后的链表返回。
        return newList;
    }

    public static void main(String[] args) {
        LeetCode_mianshi24 leetCode_mianshi24 = new LeetCode_mianshi24();
        leetCode_mianshi24.reverseList(ListNode.getListNode());
        ListNode r1 = leetCode_mianshi24.result;
        ListNode.printList(r1);
    }


}
