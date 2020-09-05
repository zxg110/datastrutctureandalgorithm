package com.zxg.algorithm.LeetCode.DP;

/**
 * 有n[]种硬币，拼出M块钱最少需要多少枚硬币 状态转移:f[X] =
 * min{f(M-n[0])+1,f(M-n[1])+1....f(M-[n-1]+1)}
 */
public class CoinChange {
    public int coinChange(int[] n, int M) {
        int result = Integer.MAX_VALUE;
        // 计算1块钱到M块钱 的 最少需要硬币数量
        int[] money = new int[M + 1];
        // 初始状态:拼出1块钱需要0枚硬币
        money[0] = 0;
        for (int i = 1; i <= M; i++) {
            // 先假设i块钱拼不出来
            money[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n.length; j++) {
                // 条件:1.money[i](i块钱得大于硬币面额) 2.money[i-n[j]]（i块钱-面额n[j]）得能拼出来出来，否则无意义
                // 举个例子money[3] 拼3块钱，本次循环到面额n[j]=2，只有面额(2,5,7)
                // 1块钱(money[i-n[j]]即:money(3-2))是拼不出来的,那么money[3]必然拼不出
                // 则不需要进行本次计算
                if (money[i] > n[j] && money[i - n[j]] != Integer.MAX_VALUE) {
                    // 和上一次计算比较，取小值
                    money[i] = Math.min(money[i - n[j]] + 1, money[i]);
                }

            }

        }
        // money[M]最终结果，赋值成-1返回，没有什么特殊意义，-2也行
        if (money[M] == Integer.MAX_VALUE) {
            money[M] = -1;
        }
        return money[M];
    }
    //计算过的内容均使用数组记录下来了，例如money[2] = 1 下次再使用到money[2](总额为2，最少需要多少枚硬币能拼出来)时，可以直接用
    //而递归没有记录则计算量大
}
