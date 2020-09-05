package com.zxg.algorithm.LeetCode.DP;

/**
 * 给定一个m*n的矩形网格，一个机器人从左上角出发，每次可以向下或向右走一步，不可以向上或向左走问有多少种方式走到右下角
 * 
 * 定义状态:f[m][n]代表走到坐标(m,n)有多少种方式 状态转移方程:f[m][n] = f[m][n-1]+f[m-1][n]
 * 由于只能向下或向右走，所以走到(m,n)的上一步必定是(m,n-1)或(m-1,n)，所以子问题就是有多少种方式走到(m,n-1)和(m-1,n)
 * 初始状态 f[0][0] = 1 边界情况:当m=0或n=0 则只能有一种方式，那就是一直向右走或者一直向下走，所以当m=0或n=0时，f[m][n] =
 * 1 计算顺序：原则还是左边用到的数据 右边的式子已经需要算过了
 */
public class Robot {
    public int calculeRobotStep(int m, int n) {
        // size是[m][n]因为坐标从0开始，到[0][0]到[m-1][n-1]已经有m*n个格子了
        int[][] gird = new int[m][n];
        gird[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    gird[i][j] = 1;
                    continue;
                }
                gird[i][j] = gird[i][j - 1] + gird[i - 1][j];
                //这样写也一样，这样写更好理解
                /*if (i == 0 || j == 0) {
                    gird[i][j] = 1;
                }else{
                    gird[i][j] = gird[i][j - 1] + gird[i - 1][j];
                }
                **/
                
            }
        }
        return gird[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new Robot().calculeRobotStep(3, 3)); 
    }
}
