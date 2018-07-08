package com.zxg.algorithm.sort;

/**
 * 选择排序：
 * 思路：外层循环位置，内层拿该位置数值与所有后边数值比较，外层循环每次找到最小的值
 * 数组前i个数值是已排序好的，所以用第i个位置的数值与后边所有值做比较，找到比他小的换位置
 *
 */
public class SelectionSort extends Sort {
    @Override
    public int[] sort(int[] originalData) {
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
