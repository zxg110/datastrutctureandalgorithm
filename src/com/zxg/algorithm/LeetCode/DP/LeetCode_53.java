package com.zxg.algorithm.LeetCode.DP;

/**
 * 动态规划：很简单，定义一个数组，dp[]，dp[i]以第i个元素为结尾的一段最大子序和。
 * 求dp[i]时，假设前面dp[0]~dp[i-1]都已经求出来了，dp[i-1]表示的是以i-1为结尾的最大子序和
 * ，若dp[i-1]小于0，则dp[i]加上前面的任意长度的序列和都会小于不加前面的序列
 * （即自己本身一个元素是以自己为结尾的最大自序和）。举个例子：如-2，1，-3，4数组，
 * dp[0]=-2；dp[1]=1(因为前一个dp[0]=-2<0，即（-2，1）子序和为-1，一个元素（1）子序和为1）；
 * dp[2]=dp[1]+nums[2]=1+(-3)=-2；dp[3]=4，因为dp[2]<0；

 */
public class LeetCode_53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int max = nums[0];
        //a[i]代表以i为结束的子串的最大长度
        int[] a = new int[nums.length];
        a[0] = nums[0];
        for(int i=1;i<a.length;i++){
            if(a[i-1]>0){
                a[i]= a[i-1]+nums[i];
            }else{
                a[i] = nums[i];
            }
            max = Math.max(max,a[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] testData = {-2,1,-3,4,-1,2,1,-5,4};
        LeetCode_53 leetCode_53 = new LeetCode_53();
        System.out.println("result:"+leetCode_53.maxSubArray(testData));
    }


}
