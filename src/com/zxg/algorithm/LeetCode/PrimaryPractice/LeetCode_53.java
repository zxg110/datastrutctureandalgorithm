package com.zxg.algorithm.LeetCode.PrimaryPractice;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 思路：动态规划
 * 以 【第i个元素结尾的子串和的最大值 】
 * 记为 f[i]，则f[i] = max{f[i-1]+array[i],array[i]}。
 * 要求【第i个元素结尾的子串和 的最大值】，
 * 即看【第i个元素】和【第i个元素】+【第i-1个元素结尾的子串和 的的最大值】哪一个大。
 * <p>
 * 思考过程中有这样一个误区，那就是没有彻底理解【第i个元素结尾的子串的和 的最大值】
 * 例如i=5 那么该最大值一定是所有组合的最大值，可能是第1个到第4个，可能是第2个到第3个
 */
public class LeetCode_53 {

    public int max(int[] data) {
        int length = data.length;
        //用于记录前n个元素的最大值
        int[] maxs = new int[length];
        for (int i = 1; i < length; i++) {
            int temp1 = data[i];
            int temp2 = data[i] + maxs[i - 1];
            maxs[i] = temp1 > temp2 ? temp1 : temp2;
        }
        //找出maxs中最大值
        int result = maxs[0];
        for (int i = 1; i < length; i++) {
            if (maxs[i] > result)
                result = maxs[i];
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_53 leetCode = new LeetCode_53();
        int[] data = {-1,5,7,2};
        System.out.printf("max:"+leetCode.max(data));
    }

}
