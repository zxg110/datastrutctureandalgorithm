package com.zxg.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 有1，2,3,4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少
 */
public class Algorithm_2 {
    public static void main(String[] args) {
        List<String> result = getNumber();
        for (String s : result) {
            System.out.printf("number:" + s + "\n");
        }

    }

    private static List<String> getNumber() {
        List<String> result = new ArrayList<String>();
        int i, j, k;
        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= 4; j++) {
                for (k = 1; k <= 4; k++) {
                    if (!isEquals(i, j) && !isEquals(j, k) && !isEquals(k, i)) {
                        result.add("" + i + j + k);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isEquals(int firstNumber, int secondNumber) {
        return firstNumber == secondNumber;
    }
}
