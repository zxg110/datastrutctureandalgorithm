package com.zxg.algorithm;

/**
 * I am a boy 转换为 boy a am I
 */
public class AlgorithmPractice_13 {
    public static void main(String[] args) {
        String orignal = "I am a boy";
        String[] array = orignal.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            builder.append(array[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        System.out.printf(builder.toString());
    }
}
