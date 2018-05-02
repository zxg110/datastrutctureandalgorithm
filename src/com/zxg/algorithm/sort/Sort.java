package com.zxg.algorithm.sort;

import java.util.Arrays;

public abstract class Sort {
    public static int[] result;

    public abstract int[] sort(int[] originalData);

    public static void printResult() {
        System.out.printf(Arrays.toString(result));
    }
}
