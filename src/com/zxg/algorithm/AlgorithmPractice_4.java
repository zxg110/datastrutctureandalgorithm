package com.zxg.algorithm;

import java.util.Stack;

/**
 * 使用两个栈实现一个队列
 */
public class AlgorithmPractice_4 {

    public class StackQueue<T> {
        private Stack<T> stack_1 = new Stack<T>();
        private Stack<T> stack_2 = new Stack<T>();

        public void add(T element) {
            stack_1.push(element);

        }

        public T take() {
            if (stack_2.empty()) {
                while (!stack_1.empty()) {
                    stack_2.push(stack_1.pop());
                }
            }
            return stack_2.pop();
        }

    }

    public static void main(String[] args) {
        AlgorithmPractice_4.StackQueue<String> queue = new AlgorithmPractice_4().new StackQueue<String>();
        queue.add("one");
        queue.add("two");
        System.out.println("take:" + queue.take());
        queue.add("three");
        System.out.println("take:" + queue.take());
        System.out.println("take:" + queue.take());
    }

}
