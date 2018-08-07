package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * 给定 "dvdf"，最长子串是"vdf"，长度是3
 * <p>
 * 参考：https://blog.csdn.net/qq_28618765/article/details/65627503
 */
public class LeetCode_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLength = 0;
        int curStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (indexMap.containsKey(s.charAt(i))) {
                //更新curStsrt
                curStart = Math.max(curStart, indexMap.get(s.charAt(i)) + 1);
            }
            //更新最大长度
            maxLength = maxLength > (i - curStart + 1) ? maxLength : (i - curStart + 1);
            //更新字符位置
            indexMap.put(s.charAt(i), i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String orignalStr = "dvdf";
        LeetCode_3 leetCode_3 = new LeetCode_3();
        System.out.println("longest subString length:" + leetCode_3.lengthOfLongestSubstring(orignalStr));
    }
}
