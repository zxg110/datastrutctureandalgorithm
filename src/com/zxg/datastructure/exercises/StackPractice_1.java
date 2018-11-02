package com.zxg.datastructure.exercises;

import java.util.Stack;

/**
 * 给定两个参数，第一个为入栈顺序，判断第二个参数是否为出栈顺序
 */
public class StackPractice_1 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0)
            return false;
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();// 辅助用的栈
        // 用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // 如果栈不为空，且栈顶元素等于弹出序列
            //stack.peek()查看栈顶元素，并不弹出
            while (!stack.empty() && stack.peek() == popA[popIndex]) {
                // 出栈
                stack.pop();
                // 弹出序列向后一位
                popIndex++;
            }
        }
        return stack.isEmpty();

    }
}
