package com.zxg.algorithm.LeetCode.DP;

public class Practice_1 {

    public int maxSubLength(int[] data){
        int[] f = new int[data.length];
         for(int i=0;i<f.length;i++){
             f[i] = 1;
         }
         for(int i=0;i<data.length;i++){
             for(int j=0;j<i;j++){
                 if(data[j]<data[i]){
                     f[i] = Math.max(f[i],f[j]+1);
                 }

             }
             System.out.println("f[i]="+f[i]);
         }
         return 0;
    }

    public static void main(String[] args) {
        int[] data = {1,5,3,4,6,9,7,8};
        Practice_1 practice_1 = new Practice_1();
        practice_1.maxSubLength(data);
    }
}
