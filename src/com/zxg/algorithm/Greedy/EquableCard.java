package com.zxg.algorithm.Greedy;

/**
 * 均分纸牌问题
 * 有 N 堆纸牌，编号分别为 1，2，…, N。每堆上有若干张，但纸牌总数必为 N 的倍数。可以在任一堆上取若于张纸牌，
 * 然后移动。移牌规则为：在编号为 1 堆上取的纸牌，只能移到编号为 2 的堆上；在编号为 N 的堆上取的纸牌，
 * 只能移到编号为 N-1 的堆上；其他堆上取的纸牌，可以移到相邻左边或右边的堆上。
 * 现在要求找出一种移动方法，用最少的移动次数使每堆上纸牌数都一样多。
 * <p>
 * 个人分析：
 * 只要当前堆的牌数不等于平均数，就一定要移,那么最多移动N-1次
 * 这里可以把移动牌的数量当做负数，这是理解这个问题的关键
 *
 * 这个问题可以采取贪心算法的关键在于无后效性，我移动当前牌堆，只影响i和i+1堆，目的是将这第i堆牌数调整为
 * 平均数，和后边所有堆都没有关系。因为目的就是每一堆都是平均数。那么总体的目标就可以分为每一个小目标
 * 为了调整到这个小目标，就将当前堆和下一堆作为调整空间进行调整，用下一堆的牌来保证将当前堆调整为平均值
 * 如果不够，可以先设置成负数，再用下一堆来补充它
 *
 * 贪心算法所作的选择可以依赖于以往所作过的选择，但决不依赖于将来的选择，也不依赖于子问题的解，因此贪心算法与其他算法相比具有一定的速度优势。
 * 如果一个问题可以同时用几种方法解决，贪心算法应该是最好的选择之一。
 * 参考：
 * https://blog.csdn.net/qq_31698195/article/details/62225161
 * https://blog.csdn.net/u011035622/article/details/43650869
 */
public class EquableCard {

    public static void main(String[] args) {
        int[] card = new int[]{9, 8, 17, 6};
        System.out.printf("min count:" + findMinCount(card));
    }

    public static int findMinCount(int[] card) {
        int N = card.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < card.length; i++) {
            sum += card[i];
        }
        int average = sum / card.length;
        for (int i = 0; i < card.length; i++) {
            if (card[i] - average != 0) {
                card[i + 1] = card[i + 1] + card[i] - average;
                count++;
            }
        }
        return count;
    }
}
