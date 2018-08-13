package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.LinkedList;
import java.util.List;

/**
 * 电话号码和组合字母
 */
public class LeetCode_17 {
    List<String> res;

    public List<String> letterCombinations(String digits) {
        // 建立映射表
        String[] table = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder tmp = new StringBuilder();
        res = new LinkedList<String>();
        helper(table, 0, tmp, digits);
        return res;
    }

    private void helper(String[] table, int idx, StringBuilder tmp, String digits) {
        if (idx == digits.length()) {
            // 找到一种结果，加入列表中
            if (tmp.length() != 0) res.add(tmp.toString());
        } else {
            // 找出当前位数字对应可能的字母
            String candidates = table[digits.charAt(idx) - '0'];
            // 对每个可能字母进行搜索
            for (int i = 0; i < candidates.length(); i++) {
                tmp.append(candidates.charAt(i));
                helper(table, idx + 1, tmp, digits);
                //回溯一位
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_17 leetCode = new LeetCode_17();
        List<String> list = leetCode.letterCombinations("23");
        for (String s : list) {
            System.out.printf(s + " ");
        }
    }
}
