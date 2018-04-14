package com.zxg.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 */
public class AlgorithmPractice_5 {

    class QueueStack<T> {
        Queue<T> queue_1 = new LinkedList<T>();
        Queue<T> queue_2 = new LinkedList<T>();

        public void push(T element) {
            queue_1.offer(element);
        }

        public T pop() {
            if (queue_1.isEmpty())
                throw new RuntimeException("queue is null");
            while (queue_1.size() != 1) {
                queue_2.offer(queue_1.poll());
            }
            while (queue_2.size() != 0) {
                queue_1.offer(queue_2.poll());
            }
            return queue_1.poll();
        }
    }

    public static void main(String[] args) {
        AlgorithmPractice_5.QueueStack<Integer> stack = new AlgorithmPractice_5().new QueueStack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println("pop:" + stack.pop());
        stack.push(3);
        System.out.println("pop:" + stack.pop());
        System.out.println("pop:" + stack.pop());
    }
}
