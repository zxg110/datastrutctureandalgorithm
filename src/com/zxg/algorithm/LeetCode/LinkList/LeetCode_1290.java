package com.zxg.algorithm.LeetCode.LinkList;

/**
 * 链表2进制转10进制
 * 1->0->1 输出5
 * 思路：递归到最后一个节点，再利用递归性质一个一个往回算
 */

public class LeetCode_1290 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    static double  result = 0;
    static int i=0;
    public static void getDecimalValue(ListNode head){
        if (head.next != null){
             getDecimalValue(head.next);
        }

        System.out.println("process head:"+head.val+"result:"+result+",i:"+i);
        if(head.val == 1){
            result = result+Math.pow(2,i);
        }
        i++;
    }

    public static void main(String[] args) {
        ListNode l1 = new LeetCode_1290.ListNode(1);
        ListNode l2 = new LeetCode_1290.ListNode(1);
        ListNode l3 = new LeetCode_1290.ListNode(1);
        l1.next = l2;
        l2.next = l3;
        LeetCode_1290.getDecimalValue(l1);
        System.out.println(LeetCode_1290.result);
    }
}
