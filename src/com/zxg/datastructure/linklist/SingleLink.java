package com.zxg.datastructure.linklist;

/**
 * Created by zengxiangge on 2018-3-13.
 */

public class SingleLink<T> {
    Node head = null;

    public void addNode(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void deleteNode() {
        Node temp = head;
        if (temp == null) {
            return;
        }
        if (temp.next == null) {
            head = null;
            return;
        }
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    /**
     * index start with 0:head index is 0
     *
     * @param index
     * @return
     */
    public boolean deleteNodeByIndex(int index) {
        if (index < 0 || index > length() - 1) {
            return false;
        }
        if (index == 0) {
            head = head.next;
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            i++;
            preNode = curNode;
            curNode = curNode.next;
        }
        return false;
    }

    /**
     * index start with 0:head index is 0
     *
     * @param index
     */
    public boolean insertNodeByIndex(T data, int index) {
        if (index < 0 || index > length()) {
            return false;
        }
        Node node = new Node(data);
        if (index == 0) {
            node.next = head;
            head = node;
            return true;
        }
        if (index == length()) {
            addNode(data);
            return true;
        }
        int i = 1;
        Node preNode = head;
        Node curNode = head.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = node;
                node.next = curNode;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return false;

    }

    public int length() {
        Node temp = head;
        if (temp == null) return 0;
        int length = 1;
        while (temp.next != null) {
            length += 1;
            temp = temp.next;
        }
        return length;
    }


    public void printLink() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println("data:" + temp.data);
            temp = temp.next;
        }
        System.out.println("data:" + temp.data);
    }

    public void reverseIteratively() {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;
        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        this.head = pReversedHead;
        return;
    }

    public void printLinkReversely(){
        if(length() == 0) return;
        if(length() == 1){
            System.out.printf("data:"+head.data+"\n");
            return;
        }
        printLinkReversely(head);

    }

    private void printLinkReversely(Node node) {
        if (node.next != null) {
            node = node.next;
            printLinkReversely(node);
            System.out.println("node data:" + node.data);
        }
    }

    public boolean isLoop() {
        if (head == null) return false;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;

        }
    }

}
