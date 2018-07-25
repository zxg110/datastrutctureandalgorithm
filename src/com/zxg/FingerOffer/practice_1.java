package com.zxg.FingerOffer;

/**
 * 二维数组查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class practice_1 {
    public static void main(String[] args) {
        int[][] arrs = new int[][]{{1, 2, 8}, {2, 4, 9}, {4, 7, 10}, {6, 8, 11}};
        System.out.println("is find:" + Find(arrs, 10));

    }

    public static boolean Find(int[][] arrs, int target) {
        int rowLen = arrs.length;
        int columnLen = arrs[0].length;
        int i = rowLen - 1;
        int j = 0;
        while (i >= 0 && j < columnLen) {
            if (arrs[i][j] > target) {
                i--;
            } else if (arrs[i][j] < target) {
                j++;
            } else {
                System.out.println("find target:" + arrs[i][j]);
                return true;
            }
        }
        return false;
    }
}
