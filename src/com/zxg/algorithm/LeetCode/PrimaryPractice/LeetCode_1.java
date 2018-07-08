package com.zxg.algorithm.LeetCode.PrimaryPractice;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
    /**
     * 时间复杂度为o(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int firstNumber = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if ((firstNumber + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度为o(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByMap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int v = target - nums[i];
            if (map.containsKey(v) && map.get(v) != i) {
                result[0] = i;
                result[1] = map.get(v);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = {2, 9, 7, 11, 15};
        LeetCode_1.twoSum(test, 20);
    }

}
