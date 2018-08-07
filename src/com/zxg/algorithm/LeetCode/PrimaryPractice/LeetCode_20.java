package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * (){}[] true
 * ({[]}) true
 * [(]) false
 */
public class LeetCode_20 {
    public boolean isValid(String s) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (stringStack.isEmpty()) {
                stringStack.push(current);
            } else {
                if (isPair(stringStack.peek(), current)) {
                    stringStack.pop();
                } else {
                    stringStack.push(current);
                }
            }
        }
        return stringStack.isEmpty();
    }

    private boolean isPair(String str1, String str2) {
        if ("[".equals(str1)) {
            return "]".equals(str2);
        } else if ("(".equals(str1)) {
            return ")".equals(str2);
        } else if ("{".equals(str1)) {
            return "}".equals(str2);
        }
        return false;
    }

    public static void main(String[] args) {
        String testStr = "([)]";
        LeetCode_20 leetCode_20 = new LeetCode_20();
        System.out.println("isValid:" + leetCode_20.isValid(testStr));

    }
}
