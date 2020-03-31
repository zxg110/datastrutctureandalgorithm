package com.zxg.algorithm.sort;

/**
 * 单链表数据结构的插入排序
 * https://blog.csdn.net/vv_017/article/details/80502837
 */
public class InsertionSortByLinkLedList{

    public Node sort(Node head) {
        return head;
    }

    public Node createLinkedList(){
        Node head = new Node(3);
        Node v1 = new Node(5);
        Node v2 = new Node(5);
        Node v3 = new Node(5);
        Node v4 = new Node(5);
        Node v5 = new Node(5);


        head.next = v1;
        v1.next = v2;
        v2.next = v3;
        v3.next = v4;
        v4.next = v5;
        return head;
    }

    public static void main(String[] args) {

    }
}

class Node{
    public Node(int value){
        this.value = value;
    }
    int value;
    Node next;
}
