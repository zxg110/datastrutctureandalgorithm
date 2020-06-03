package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;

public class LeetCode_1047 {
    public String removeDuplicates(String S) {
        char[] s = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            if (stack.isEmpty() || !stack.peek().equals(s[i])) {
                stack.push(s[i]);
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        LeetCode_1047 leetCode_1047 = new LeetCode_1047();
        System.out.println(leetCode_1047.removeDuplicates("abbaca"));

    }
}
