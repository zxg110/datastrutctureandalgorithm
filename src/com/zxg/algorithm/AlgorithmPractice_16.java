package com.zxg.algorithm;

import java.util.BitSet;

/**
 * 给定一个 1-100 的整数数组，请找到其中缺少的数字
 */
public class AlgorithmPractice_16 {

    public void sloveByBitSet(){
        int[] date = new int[]{0,1,3,4,6,7,8,10,11,12,13,15,17,18,20};
        int[] mock = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        BitSet dateSet = new BitSet();
        BitSet mockSet = new BitSet();
        for(int i=0;i<date.length;i++){
            dateSet.set(date[i]);
        }

        for(int i=0;i<mock.length;i++){
            mockSet.set(mock[i]);
        }
        mockSet.xor(dateSet);
        System.out.println(mockSet);
    }

    public static void main(String[] args) {
        AlgorithmPractice_16 solution = new AlgorithmPractice_16();
        solution.sloveByBitSet();
    }
}
