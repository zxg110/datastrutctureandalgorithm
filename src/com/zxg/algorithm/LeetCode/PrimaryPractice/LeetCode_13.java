package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class LeetCode_13 {
    static Map<Character, Integer> numberMap;

    static {
        numberMap = new HashMap<>();
        numberMap.put('I', 1);
        numberMap.put('V', 5);
        numberMap.put('X', 10);
        numberMap.put('L', 50);
        numberMap.put('C', 100);
        numberMap.put('D', 500);
        numberMap.put('M', 1000);
    }

    private int compare(Character n1, Character n2) {
        int diff = numberMap.get(n1) - numberMap.get(n2);
        if (diff >= 0)
            return 1;
        else
            return -1;
    }

    public int romanToInt(String s) {
        int index = s.length() - 1;
        int result = numberMap.get(s.charAt(index));
        for (int i = index - 1; i >= 0; i--) {
            if (compare(s.charAt(i), s.charAt(i + 1)) > 0) {
                result += numberMap.get(s.charAt(i));
            } else {
                result -= numberMap.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_13 leetCode = new LeetCode_13();
        System.out.println(leetCode.romanToInt("CCCLVI"));
    }
}
