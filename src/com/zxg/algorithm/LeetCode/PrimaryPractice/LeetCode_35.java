package com.zxg.algorithm.LeetCode.PrimaryPractice;

/**
 * 给定一个排序数组和一个目标值，
 * 在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class LeetCode_35 {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }

            if (target > nums[i]) {
                if (i != nums.length - 1 && target <= nums[i + 1]) {
                    return i + 1;
                } else {
                    continue;
                }
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        LeetCode_35 leetCode_35 = new LeetCode_35();
        System.out.println("result:" + leetCode_35.searchInsert(new int[]{1}, 1));
    }
}
