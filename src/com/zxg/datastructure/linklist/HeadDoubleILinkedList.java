package com.zxg.datastructure.linklist;

public class HeadDoubleILinkedList<T> implements ILinkedList<T> {
    //head不包含数据,只含有head的list，length为0
    protected DNode<T> head;
    protected DNode<T> tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        int length = 0;
        if (isEmpty())
            return 0;
        DNode<T> next = head.next;
        while (next != null) {
            length += 1;
            next = next.next;
        }
        return length;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= length() || isEmpty())
            return null;
        if (index == 0)
            return head.next.data;
        if (index == length() - 1)
            return tail.data;
        int tempIndex = 0;
        DNode<T> next = head.next;
        while (next != null && tempIndex < index) {
            tempIndex += 1;
            next = next.next;
        }
        return next == null ? next.data : null;
    }

    @Override
    public T set(int index, T data) {
        T old = null;
        if (index > 0 && data != null) {
            int j = 0;
            DNode<T> pre = this.head.next;
            //查找需要替换的位置
            while (pre != null && j < index) {
                j++;
                pre = pre.next;
            }
            if (pre != null) {
                old = pre.data;
                //替换数据
                pre.data = data;
            }
        }
        return old;
    }

    @Override
    public boolean add(int index, Object data) {
        if (index < 0 || index >= length() || isEmpty())
            return false;
        int tempIndex = 0;
        DNode<T> temp = head.next;
        while (temp != null && tempIndex < index) {
            tempIndex++;
            temp = temp.next;
        }
        DNode<T> newNode = new DNode<T>();
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next.prev != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        if (temp.equals(this.tail))
            this.tail = newNode;
        return true;
    }

    @Override
    public boolean add(T data) {
        if (data == null || isEmpty() || tail == null)
            return false;
        DNode<T> newNode = new DNode<T>(data, tail, null);
        tail.next = newNode;
        this.tail = newNode;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length() || isEmpty())
            return null;
        int tempIndex = 0;
        DNode<T> temp = head.next;
        while (temp != null && tempIndex < index) {
            tempIndex++;
            temp = temp.next;
        }
        T result = temp.data;
        temp.prev = temp.next;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.equals(this.tail))
            this.tail = temp.prev;
        return result;
    }

    @Override
    public boolean remove(Object data) {
        boolean isRemove = false;

        if (data == null || isEmpty())
            return isRemove;
        DNode<T> p = this.head.next;

        //头删除/尾删除/中间删除(size>1),查找所有需要删除的结点
        while (p != null) {

            if (data.equals(p.data)) {
                if (p == this.tail) {
                    //如果是尾结点
                    this.tail = p.prev;//更新未结点的指向
                    p.prev = null;
                    this.tail.next = null;
                } else {
                    //如果是在中间删除,更新前继和后继指针指向
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                }
                isRemove = true;
                p = p.next;//继续查找
            } else {
                p = p.next;
            }

        }
        return isRemove;
    }

    @Override
    public void clear() {
        this.head.next = null;
        this.tail = this.head;
    }

    @Override
    public boolean contains(Object data) {
        if (data == null) {
            return false;
        }

        DNode<T> p = this.head.next;
        while (p != null) {
            if (data.equals(p.data)) {
                return true;
            } else {
                p = p.next;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String str = "(";
        DNode<T> pre = this.head.next;
        while (pre != null) {
            str += pre.data;
            pre = pre.next;
            if (pre != null)
                str += ", ";
        }
        return str + ")";
    }

    public void reverseIteratively() {
        if (head == null || tail == null)
            return;
        DNode<T> pre = null;
        DNode<T> next = null;
        DNode<T> newFirst = null;
        DNode<T> newLast = null;
        for (DNode<T> node = head; node != null; node = node.prev) {
            pre = node.prev;
            next = node.next;
            if (node.prev == null) {
                newLast = node;
            }
            if (node.next == null) {
                newFirst = node;
            }
            node.next = pre;
            node.prev = next;
        }
        head = newFirst;
        tail = newLast;

    }

    class DNode<T> {

        public T data;
        public DNode<T> prev, next;//前继指针和后继指针

        public DNode(T data, DNode<T> prev, DNode<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public DNode(T data) {
            this(data, null, null);
        }

        public DNode() {
            this(null, null, null);
        }

        public String toString() {
            return this.data.toString();
        }
    }

}
