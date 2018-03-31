package com.zxg.algorithm.sort;

public class SelectionSort extends Sort {


    @Override
    public int[] Sort(int[] originalData) {
        for (int i = 0; i < originalData.length; i++) {
            int data = originalData[i];
            for (int j = i + 1; j < originalData.length; j++) {
                if (originalData[i] > originalData[j]) {
                    int temp = originalData[i];
                    originalData[i] = originalData[j];
                    originalData[j] = temp;
                }
            }
        }
        return originalData;
    }
}
