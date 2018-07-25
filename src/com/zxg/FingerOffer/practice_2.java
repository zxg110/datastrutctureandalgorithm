package com.zxg.FingerOffer;

/**
 * 从尾到头打印链表
 */
public class practice_2 {
    public static void main(String[] args) {
        Node n1 = new Node("head");
        Node n2 = new Node("second");
        Node n3 = new Node("third");
        Node n4 = new Node("fourth");
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        printReversal(n1);
    }

    public static void printReversal(Node head) {
        if (head == null) {
            return;
        }
        printReversal(head.next);
        System.out.println(head.value);
    }
}

class Node {
    Node next;
    String value;

    public Node(String value) {
        this.value = value;
    }
}
