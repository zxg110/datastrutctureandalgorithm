package com.zxg.algorithm.sort;

/**
 * 冒泡排序
 * 思路：整个过程就想气泡一样往上升，假设从小到大排序，对于给定的n个记录，
 * 从第一个记录开始依次对相邻的两个记录进行比较，当前面的记录大于后面的记录时，
 * 交换位置，进行一轮比较后，第n位上就是整个记录中最大的数，然后在对前n-1个记录进行第二轮比较，
 * 重复该过程直到进行比较的记录只剩下一个为止。
 */
public class BubbleSort extends Sort {
    @Override
    public int[] sort(int[] originalData) {
        //外层循环代表n次排序过程
        for(int i=0;i<originalData.length;i++){
            for(int j=1 ;j<originalData.length-i;j++){
                if(originalData[j-1]>originalData[j]){
                    int temp = originalData[j];
                    originalData[j] = originalData[j+1];
                    originalData[j+1] = temp;
                }
            }
        }
        return originalData;
    }

    public static void main(String[] args) {

        int[] result = new BubbleSort().sort(new int[]{5,2,3,8,4,1,6});
        System.out.println(result.toString());
    }
}
