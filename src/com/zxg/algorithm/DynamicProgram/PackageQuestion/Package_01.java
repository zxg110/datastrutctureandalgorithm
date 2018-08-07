package com.zxg.algorithm.DynamicProgram.PackageQuestion;

/**
 * 01背包问题 将重量为(w1,w2,w3,w4,w5...)、价值为(v1,v2,v3,v4,v5...)的物品放入容量为N的背包中，怎样放价值最大
 * 动态规划：
 * 我们设v[i][j]为放入前i个物品到容量为j的背包中的最大值，i一定是小于物品总个数的，j一定是小于N的
 * 举个例子 v[2][5]表示将前两个物品放入容量为5的背包中的最大价值 v[2][6]表示将前两个物品放入容量为6的背包中的最大价值
 * 则有等式：
 * v[0][j] = v[j][0] = 0
 * v[i][j] = v[i-1][j] w[i]>j
 * v[i][j] = Max(v[i-1][j],v[i-1][j-w[i]]+value[i]) w[i] <= j
 * 暴力求解：
 * 求出物品个数的所有子集，计算每一个子集的价值，选出最大值
 * 例如有4个物品，那么2^4=16个子集，每个子集有四位，每一位是0代表该子集中没有该物品，是1代表有该物品
 * 0 0 0 0 代表该子集中没有任何物品
 * 0 1 0 1 代表该子集中有2号物品和4号物品
 */
public class Package_01 {

    /**
     * 动态规划
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public static int maxValue(int[] weight, int[] value, int capacity) {
        int weightLen = weight.length;
        /**
         * 列值长度加1，是因为最后一列要保证重量值为lenColumn
         * 而weightLen不用加的原因是weightLen=0时，代表放入前0个，这里的0是下表i，数组下表是从0开始的
         */
        int valueLen = capacity + 1;
        int maxValue = 0;
        int[][] v = new int[weightLen][valueLen];
        for (int i = 0; i < weightLen; i++) {
            for (int j = 0; j < valueLen; j++) {
                if (i == 0) {
                    v[i][j] = 0;
                } else if (j == 0) {
                    v[i][j] = 0;
                } else {
                    if (weight[i] > j) {
                        v[i][j] = v[i - 1][j];

                    } else if (weight[i] <= j) {
                        v[i][j] = Math.max(v[i - 1][j], v[i - 1][j - weight[i]] + value[i]);
                    }
                    maxValue = v[i][j];
                }

            }

        }
        return maxValue;
    }

    /**
     * 暴力求解
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public static int maxValueForce(int[] weight,int[] value,int capacity){
        //子集个数
        int row = (int)Math.pow(2,weight.length);
        //每个子集中元素个数，就是物品的个数
        int column = weight.length;
        //物品子集
        int[][] goodsSubset = new int[row][column];
        //最大价值
        int maxValue = 0;
        //填充所有子集
        for(int i=0;i<row;i++){
            int temp_1 = i;
            for(int j=0;j<column;j++){
                int temp_2 = temp_1%2;
                goodsSubset[i][j] = temp_2;
                temp_1 = temp_1/2;
            }
        }
        //遍历子集，为每一个子集计算总价值，输出总价值最大的子集
        for(int i=0;i<goodsSubset.length;i++){
            int tempWeight = 0;
            int tempValue = 0;
            for(int j=0;j<goodsSubset[i].length;j++){
                System.out.printf(goodsSubset[i][j]+" ");
                tempWeight += goodsSubset[i][j]*weight[j];
                tempValue += goodsSubset[i][j]*value[j];
            }
            System.out.print("\t"+"总重量为："+ tempWeight);
            if(tempWeight <= capacity){
                System.out.printf("\t"+"总价值为："+tempValue);
            }else {
                System.out.printf("\t"+"不可行，超出背包最大承重");
            }
            if(tempWeight <= capacity && tempValue>maxValue){
                maxValue = tempValue;
            }
            System.out.println();
        }
        System.out.println("最大值："+maxValue);
        return maxValue;
    }

    public static void main(String[] args) {
//        int[] weight = {1, 3, 5, 7, 1};
//        int[] value = {2, 4, 3, 6, 3};
        int[] weight = {7,3,4,5};
        int[] value = {42,12,40,25};
        int capacity = 10; //容量
        System.out.println(maxValue(weight, value, capacity));
    }

}
