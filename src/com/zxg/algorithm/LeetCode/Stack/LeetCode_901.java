package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;

//股票价格波动
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
