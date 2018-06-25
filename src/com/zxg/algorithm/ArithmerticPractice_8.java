package com.zxg.algorithm;
/**
 * Created by zengxiangge on 2018-4-20.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class ArithmerticPractice_8 {
    public static boolean findNumber(int[][] source,int target){
        for(int i = 0;i<source.length;i++){
            int[] array = source[i];
            for(int j = 0;j<array.length;j++){
                if(array[j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,5},{1},{3,2,4},{1,7,5,9}};
        System.out.println("isHave:"+findNumber(arr,5));
    }
}
