package com.zxg.algorithm.LeetCode.Stack;


import java.util.Arrays;
import java.util.Stack;
//求指定数右边的第一个比该数大的数字的下标和该数下标的距离，不存在下个更大的数的就拿0代替

/**
 * 在理解过程中有一个疑问，当前值与栈中元素对比，永远不会和已经从栈中pop的元素相比较
 * 会不会有问题，其实不会，因为之所以他们会被pop，是他们小于当前栈顶元素，那么如果
 */
public class Practice_1 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        Stack<Integer> values = new Stack<>();
        for (int curIndex = n-1; curIndex >= 0; curIndex--) {

            // 如果T[curIndex]比栈顶元素大，就pop，直到T[curIndex]<栈顶元素
            //保证栈顶元素是最小的
            while (!indexs.isEmpty() && T[curIndex] >= T[indexs.peek()]) {
                indexs.pop();
                values.pop();
            }
            if(!indexs.isEmpty()) dist[curIndex] =indexs.peek()- curIndex;
            indexs.push(curIndex);
            values.push(T[curIndex]);

        }
        return dist;
    }

    public static void main(String[] args) {
        Practice_1 practice_1 = new Practice_1();
        int[] test = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = practice_1.dailyTemperatures(test);
        System.out.println(Arrays.toString(result));
    }
}
