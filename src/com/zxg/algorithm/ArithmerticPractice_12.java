package com.zxg.algorithm;

import java.util.Arrays;

/**
 * 将数组中正负数调整到各自一边
 */
public class ArithmerticPractice_12 {
    public static int[] date = new int[]{1, -1, 4,-1,-2,-3,-5};

    public static void adjust() {
        //长度为0 1 2不需要调整
        if (date.length <=2) {
            return;
        }
        int length = date.length;
        int end = length - 1;
        for (int i = 0; i < length / 2 + 1; i++) {
            if (date[i] < 0) {
                //找到右边第一个负数并且需要i<end
                while (date[end] < 0 && i<end) {
                    end--;
                }
                //交换
                int temp = date[i];
                date[i] = date[end];
                date[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        adjust();
        System.out.println("result:" + Arrays.toString(date));
    }
}
