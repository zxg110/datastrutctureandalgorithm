package com.zxg.algorithm.LeetCode.PrimaryPractice;

/**
 * 从排序数组中删除重复项:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Practice_1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        //判断无输入
        int number = 0;//标记计数
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1; //标记+1即为数字个数
        return number;
    }

    public static void main(String[] args) {
        Practice_1 p = new Practice_1();
        int[] test = {0,0,1,1,1,2,};
        System.out.println(p.removeDuplicates(test));

    }
}
