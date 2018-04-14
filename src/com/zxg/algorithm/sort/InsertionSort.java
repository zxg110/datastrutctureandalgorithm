package com.zxg.algorithm.sort;

/**
 * 插入排序：
 * 思路：每次将前n个数看做已完成排序的序列，将n+1个数插入到该序列，已排序的序列长度变为n+1
 * 思路很好理解，代码不好理解，debug调试过程理解
 */
public class InsertionSort extends Sort{
    @Override
    public int[] sort(int[] originalData) {
        int i, j, insertNote;// 要插入的数据
        for (i = 1; i < originalData.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            insertNote = originalData[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && insertNote < originalData[j]) {
                // 如果要插入的元素小于第j个元素,就将第j个元素向后移动一位
                //第j+1个数与第j个数相同，没关系，最后一步会将正确的数值插入到第j位上
                originalData[j + 1] = originalData[j];
                //递减j
                j--;
            }
            // 直到要插入的元素不小于第j个元素,将insertNote插入到已排序数组中第j个位置
            //代码上表现的是j+1，而不是j，因为上边循环中将j做了递减操作
            originalData[j + 1] = insertNote;
        }
        return originalData;
    }

    public static void main(String[] args) {
        new InsertionSort().sort(new int[]{5,2,3,8,4,1,6});
    }
}
