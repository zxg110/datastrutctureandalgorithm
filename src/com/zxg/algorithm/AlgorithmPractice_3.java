package com.zxg.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 639172每个位数上的数字都是不同的，且平方后所得数字的所有位数都不会出现组成它自身的数字。
 * （639172*639172=408540845584），类似于639172这样的6位数还有几个？分别是什么？
 */
public class AlgorithmPractice_3 {
    public static void main(String[] args) {
        List<Long> targetNumber = new ArrayList<Long>();
        List<Long> spliteNumber = new ArrayList<Long>();
        for (long i = 100000; i < 999999; i++) {
            spliteNumber.clear();
            spliteNumber = isSelfRepeat(i);
            if (spliteNumber.size() < 6) {
                continue;
            } else if (isSquareRepeat(spliteNumber, i)) {
                continue;
            }
            targetNumber.add(i);
        }

        System.out.printf("size:" + targetNumber.size() + "\n");
        for (Long number : targetNumber) {
            System.out.printf("number:" + number + "\n");
        }
    }

    private static List<Long> isSelfRepeat(long i) {
        List<Long> splitNumber = new ArrayList<Long>();
        long targetNumber = i;
        while (targetNumber != 0) {
            long remainder = targetNumber % 10;
            targetNumber = targetNumber / 10;
            if (splitNumber.contains(remainder)) {
                return splitNumber;
            }
            splitNumber.add(remainder);

        }
        return splitNumber;
    }

    private static boolean isSquareRepeat(List<Long> spliteNumber, long i) {
        long squareNumber = i * i;
        while (squareNumber != 0) {
            long remmainder = squareNumber % 10;
            squareNumber = squareNumber / 10;
            if (spliteNumber.contains(remmainder)) {
                return true;
            }
        }
        return false;
    }

}
