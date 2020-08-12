package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;

//股票价格波动

/**
 * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是
 * [1, 1, 1, 2, 1, 4, 6]。
 */
public class LeetCode_901 {
    Stack<Integer> priceStack = new Stack<>();
    Stack<Integer> backStack = new Stack<>();
    public LeetCode_901() {

    }

    public int next(int price) {
        if(priceStack.isEmpty()){
            priceStack.push(price);
            System.out.println("price:"+price+",span:"+1);
            return 1;
        }
        int span = 0;
        priceStack.push(price);
        while (!priceStack.isEmpty()){
            int prePrice = priceStack.pop();
            if(prePrice<=price){
                span += 1;
                backStack.push(prePrice);
            }else {
                priceStack.push(prePrice);
                break;
            }
        }
        while (!backStack.isEmpty()){
            priceStack.push(backStack.pop());
        }
        System.out.println("price:"+price+",span:"+span);
        return span;
    }

    int[] data = new int[100];
    int index = 0;
    Stack<Integer> indexs = new Stack<>();

    /**
     *
     * @param price
     * @return
     * [100, 80, 60, 70, 60, 75, 85]
     *
     * 1. 位置0 100 入数组，0入栈 栈顶到栈底 [0]  return 1
     * 2. 位置1 80 入数组  1入栈 栈顶到栈底 [1，0] return 1
     * 3. 位置2 60 入数组  2入栈 栈顶到栈底 [2,1,0]  return 1
     * 4. 位置3 70 入数组  2出栈 3入栈 栈顶到栈底 [3,1,0] return 3-1=2
     *      位置2的60退出历史舞台 后边的元素再有不会和他进行比较，但是为啥呢？
     * 5. 位置4 60 入数组  4入栈 栈顶到栈底[4,3,1,0] return 1
     * 6. 位置5 75入数组 75>60 4出栈 接着比 75>70 3出栈 75<80 不比了 5入栈 栈顶到栈底[5,1,0] return 5-1=4
     * 问题来了，位置5(75)虽然没有和位置2(60)比较，但认为位置5一定大于位置2:差值计算直接是5-1，包括了2
     * 为什么？因为位置5和位置3进行过比较了，那么有两种情况，位置5的数值小于位置3数值，那么直接结束比较 return 5-3
     * 在本例中是第二种情况 位置5大于位置3，那么我们回顾下，位置3和位置2比较过，位置3数值大。那么位置5又大于位置
     * 3，所以位置5肯定大于位置2，所以不需要比较并且直接认为位置5大于位置2，包括在比位置5小的集合内。
     * 个人认为这是单调栈的精髓：减少了比较的次数。
     * 本题是：单调递增栈(栈中输入出栈序列递增)，找后边比自己大的第一个数
     *
     * 7. 位置6 85入数组，一直比较知道位置0，return 6-0
     */
    public int next1(int price){
        data[index] = price;
        if(index == 0){
            indexs.push(0);
            System.out.println("result 1");
            index++;
            return 1;
        }
        if(price<=data[indexs.peek()]){
            indexs.push(index);
            System.out.println("result 1");
            index++;
            return 1;
        }else {
            while (!indexs.isEmpty() && price > data[indexs.peek()]){
                indexs.pop();
            }
            int res = index-indexs.peek();
            indexs.push(index);
            System.out.println("result "+res);
            index++;
            return res;
        }

    }

    public static void main(String[] args) {
        /**
         * 个人认为难理解的地方在于出栈的元素就不再有记录了，所以再也不会和后边的元素做比较了
         * 那么如何理解后来的元素不需要和已出栈过的元素作比较 非常重要
         */
        LeetCode_901 leetCode_901 = new LeetCode_901();
        leetCode_901.next1(100);
        leetCode_901.next1(80);
        leetCode_901.next1(60);
        leetCode_901.next1(70);
        leetCode_901.next1(60);
        leetCode_901.next1(75);
        leetCode_901.next1(85);



    }
}
