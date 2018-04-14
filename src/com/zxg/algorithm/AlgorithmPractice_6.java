package com.zxg.algorithm;

/**
 * 跳台阶问题：
 * 一次可以跳上 1 级台阶，也可以跳上2 级。求跳上一个n 级的台阶总共有多少种跳法。
 * n=1 F(n) = 1
 * n=2 F(n) = 2
 * n= x F(n) = F(n-1)+F(n-2)
 */
public class AlgorithmPractice_6 {

    public static int getJumpMode(int steps){
        if(steps == 1)
            return 1;
        if(steps ==2)
            return 2;
        return getJumpMode(steps-1)+getJumpMode(steps-2);
    }

    public static void main(String[] args) {
        System.out.println("when steps = 1:"+getJumpMode(1));
        System.out.println("when steps = 2:"+getJumpMode(2));
        System.out.println("when steps = 3:"+getJumpMode(3));
    }
}
