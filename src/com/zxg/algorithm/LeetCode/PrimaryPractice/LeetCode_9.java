package com.zxg.algorithm.LeetCode.PrimaryPractice;

public class LeetCode_9 {

    public boolean isPalindrome(int x) {
        if(x < 0 ){
            return false;
        }else if(x == 0){
            return true;
        }
        return reverse(x) == x;
    }

    private int reverse(int x){
        long cur = x;
        long result = 0;
        while (cur != 0) {
            result = result * 10 + cur % 10;
            cur = cur / 10;
        }
        if (result > Integer.MAX_VALUE || -result > Integer.MAX_VALUE)
            return 0;
        return (int) result;
    }

    public static void main(String[] args) {
        LeetCode_9 leetCode_9 = new LeetCode_9();
        System.out.println("isPalindrome:"+leetCode_9.isPalindrome(-12321));
    }
}
