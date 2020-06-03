package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class LeetCode_mianshi0304 {


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(5);
        myQueue.push(4);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());

        System.out.println(myQueue.pop());
    }

}

class MyQueue {
    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stack2.isEmpty()) {
            stack2.push(x);
            return;
        } else {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack2.push(x);
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty();
    }
}