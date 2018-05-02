package com.zxg.algorithm.sort;

/**
 * 思路：https://www.jianshu.com/p/442399ef0cf7
 */
public class QuickSort extends Sort {
    @Override
    public int[] sort(int[] originalData) {
        int[] data = originalData;
        quickSort(originalData, 0, originalData.length - 1);
        return data;
    }

    private void quickSort(int[] data, int lowIndex, int highIndex) {
        //递归出口
        if (lowIndex > highIndex)
            return;
        int i = lowIndex;
        int j = highIndex;
        int key = data[lowIndex];
        while (i < j) {
            //从右往左找第一个小于key的数值
            while (i < j && data[j] > key) {
                j--;
            }
            //从左往右找第一个大于key的数值
            while (i < j && data[i] <= key) {
                i++;
            }
            //交换
            if (i < j) {
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        //调整key位置
        data[lowIndex] = data[i];
        data[i] = key;
        //对key左边进行排序
        quickSort(data, lowIndex, i - 1);
        //对key右边进行排序
        quickSort(data, i + 1, highIndex);
    }

    public static void main(String[] args) {
        int[] data = {4,1,3,9,6,5,7,12,2};
        result = new QuickSort().sort(data);
        printResult();
    }
}
