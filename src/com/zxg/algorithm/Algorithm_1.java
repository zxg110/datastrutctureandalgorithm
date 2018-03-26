package com.zxg.algorithm;

/**
 * 输入n,求n！（用递归的方式实现）
 */
public class Algorithm_1 {
    public static void main(String[] args) {
        int n = 5;
        System.out.print(fac(n));
    }

    private static long fac(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return n * fac(n - 1);
        }

    }
}
