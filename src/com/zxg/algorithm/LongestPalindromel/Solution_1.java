package com.zxg.algorithm.LongestPalindromel;

/**
 * 比较常规的一种思路，以每一个字符为起点，向后组装所有的子串，判断每一个子串是否是对称的
 * https://www.cnblogs.com/clnchanpin/p/6880322.html
 */
public class Solution_1 {

    public static String longestPalindrome(String orignalString) {
        int maxLength = 0;
        String finalString = null;
        int length = orignalString.length();
        for (int i = 0; i < orignalString.length(); i++) {
            for (int j = i + 1; j < length; j++) {
                int len = j - i;
                String subString = orignalString.substring(i, j + 1);
                if (isPalindrome(subString)) {
                    if (len > maxLength) {
                        finalString = subString;
                        maxLength = len;
                    }
                }
            }
        }
        return finalString;
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babcbabcbaccba"));
    }
}
