package com.zxg.algorithm.LeetCode.PrimaryPractice;

/**
 * 反转整数
 * 123 -> 321
 * 120 -> 21
 * -123 -> -321
 */
public class LeetCode_7 {
    public int reverse(int x) {
        long cur = x;
        long result = 0;
        while (cur != 0) {
            result = result * 10 + cur % 10;
            cur = cur / 10;
        }
        if (result > Integer.MAX_VALUE || -result > Integer.MAX_VALUE)
            return 0;
        return (int) result;
    }

    public static void main(String[] args) {
        LeetCode_7 leetCode = new LeetCode_7();
        System.out.println("result:" + leetCode.reverse(1534236469));
    }
}
