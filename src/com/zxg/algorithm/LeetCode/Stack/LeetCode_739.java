package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;

public class LeetCode_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> indexs = new Stack<>();
        int[] result = new int[T.length];
        for(int i=0;i<T.length;i++){
            if(i == 0){
                indexs.push(i);
                result[i] = 1;
                continue;
            }
            if(T[i]<=T[indexs.peek()]){
                indexs.push(i);
            }else{
                /**
                 * 这道题和股票901不一样的是，每个元素出栈前要把自己所代表的位置的结果
                 * 算出来再出栈
                 */
                while (!indexs.isEmpty() && T[i]>T[indexs.peek()]){
                    System.out.println("i:"+i+",indexs.peek:"+indexs.peek()+",i-indexs.peek():"+(i-indexs.peek()));
                    result[indexs.peek()] = i-indexs.peek();
                    indexs.pop();
                }
                indexs.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_739 leetCode_739 = new LeetCode_739();
        int[] test = {73, 74, 75, 71, 69, 72, 76, 73};
        leetCode_739.dailyTemperatures(test);
    }
}
