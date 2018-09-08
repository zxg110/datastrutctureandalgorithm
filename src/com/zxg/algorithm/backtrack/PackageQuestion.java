package com.zxg.algorithm.backtrack;

/**
 * 回溯法解01背包问题
 * 背包问题的概念不再赘述。这里主要讲解下回溯法思路。
 * 将每一个物品分为装载和不装载两条路径，一个接一个的遍历，每遍历一个物品就会产生两条分支
 * 那么就会组成一棵树，深度遍历这棵树，找出最优解
 * 参考：https://blog.csdn.net/jarvischu/article/details/16067319
 */
public class PackageQuestion {

    public int[] weight;
    public int[] value;
    public int[] take;

    int curWeight = 0;
    int curValue = 0;

    int bestValue = 0;
    int[] bestChoice;
    int count;

    int maxWeight = 0;

    public void init(int[] weight, int[] value, int maxWeight) {
        if (weight == null || weight.length == 0
                || value == null || value.length == 0
                || weight.length != value.length || maxWeight <= 0) {
            System.out.println("args wrong!");
            return;
        }
        this.value = value;
        this.weight = weight;
        this.maxWeight = maxWeight;
        count = value.length;
        take = new int[count];
        bestChoice = new int[count];
    }

    public int[] maxValue(int x) {
        //走到了叶子节点
        if (x > count - 1) {
            //更新最优解
            if (curValue > bestValue) {
                bestValue = curValue;
                for (int i = 0; i < take.length; i++) {
                    bestChoice[i] = take[i];
                }
            }
        } else {
            //遍历当前节点（物品）的子节点：0 不放入背包 1：放入背包
            for (int i = 0; i < 2; i++) {
                take[x] = i;
                if (i == 0) {
                    //不放入背包，接着往下走
                    maxValue(x + 1);
                } else {
                    //约束条件，如果小于背包容量
                    if (curWeight + weight[x] <= maxWeight) {
                        //更新当前重量和价值
                        curWeight += weight[x];
                        curValue += value[x];
                        //继续向下深入
                        maxValue(x + 1);
                        //回溯法重要步骤，个人感觉也是精华所在。
                        // 当从上一行代码maxValue出来后，需要回溯容量和值
                        curWeight -= weight[x];
                        curValue -= value[x];
                    }
                }
            }
        }
        System.out.println(bestValue);
        return bestChoice;
    }

    public static void main(String[] args) {
        PackageQuestion question = new PackageQuestion();
        question.init(new int[]{7, 3, 4, 5},new int[]{42, 12, 40, 25},10);
        int[] result = question.maxValue(0);


    }
}
