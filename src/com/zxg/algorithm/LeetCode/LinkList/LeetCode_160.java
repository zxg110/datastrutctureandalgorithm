package com.zxg.algorithm.LeetCode.LinkList;
//Y型交叉链表 是否交叉及交叉点

/**
 * 2->4->6->7->1->9
 * 3->5->2/
 * 交叉点是6
 */
public class LeetCode_160 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 思路
     * 1、先求长度，然后求长度差step
     * 2、指针longer指向相对较长的链表，并向前移动step步，指针shorter指向相对较短的链表
     * 3、同时移动longer和shorter，longer==shorter时即为相交点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return null;
        ListNode a = l1;
        ListNode b = l2;
        int aLength = 0;
        int bLength = 0;
        while (a.next != null) {
            a = a.next;
            aLength = aLength + 1;
        }
        while (b.next != null) {
            b = b.next;
            bLength = bLength + 1;
        }
        int step = Math.abs(aLength - bLength);
        //a是长的
        ListNode longer = l1;
        ListNode shorter = l2;
        if (aLength > bLength) {
            for (int i = 0; i < step; i++) {
                longer = longer.next;
            }
            //b是长的
        } else if (bLength > aLength) {
            longer = l2;
            shorter = l1;
            for (int i = 0; i < step; i++) {
                longer = longer.next;
            }

        }
        while (longer != null || shorter != null) {
            if (longer == shorter) {
                return longer;
            } else {
                longer = longer.next;
                shorter = shorter.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new LeetCode_160.ListNode(1);
        ListNode l2 = new LeetCode_160.ListNode(2);
        ListNode l3 = new LeetCode_160.ListNode(3);
        ListNode l4 = new LeetCode_160.ListNode(4);
        ListNode l5 = new LeetCode_160.ListNode(5);
        ListNode l6 = new LeetCode_160.ListNode(6);
        ListNode l7 = new LeetCode_160.ListNode(7);
        ListNode l8 = new LeetCode_160.ListNode(8);
        ListNode l9 = new LeetCode_160.ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l7.next = l8;
        l8.next = l9;
        l9.next = l3;
        System.out.println(LeetCode_160.getIntersectionNode(l1, l7).val);
    }
}
