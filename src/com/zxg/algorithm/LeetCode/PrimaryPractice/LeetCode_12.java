package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数转罗马数字
 */
public class LeetCode_12 {

    public String intToRoman(int num) {
        String res = "";
        int[] val ={1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < val.length; ++i) {
            while (num >= val[i]) {
                num -= val[i];
                res += str[i];
            }
        }
        return res;
    }


    private int[] splitInt(int num) {
        int[] result = new int[5];
        int count = Integer.toString(num).length();
        for (int i = 0; i < count; i++) {
            result[i] = (num % 10) * (int) Math.pow(10, i);
            num = num / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_12 leetCode = new LeetCode_12();
        System.out.println(leetCode.intToRoman(356));
    }

}
