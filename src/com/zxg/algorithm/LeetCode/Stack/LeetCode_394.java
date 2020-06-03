package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;

/**
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */

/**
 * 感悟
 * 与字符串相关的考虑使用StringBuilder操作，内存小且api丰富
 * 如果想要保持栈底到栈顶顺序，可以将从栈顶pop();使用stringbuilder.insert(0,stack.pop())保持顺序
 * 有些东西处理完了可以接着入栈，一开始就是这块没想通
 */
public class LeetCode_394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (']' == c) {
                StringBuilder stringBuilder = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    stringBuilder.insert(0, stack.pop());
                }
                //弹出来的是[
                stack.pop();
                //再把数字弹出来
                Integer times = Integer.valueOf(stack.pop());
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    temp.append(stringBuilder);
                }
                stack.push(temp.toString());
            } else if (c >= '0' && c <= '9') {
                StringBuilder stringBuilder = new StringBuilder();
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    stringBuilder.append(s.charAt(i));
                    i++;
                }
                i--;
                stack.push(stringBuilder.toString());
            } else {
                stack.push(s.substring(i, i + 1));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LeetCode_394 leetCode_394 = new LeetCode_394();
        leetCode_394.decodeString("100");
    }
}
