package com.zxg.algorithm.LeetCode.Stack;

import java.util.Stack;
//https://blog.csdn.net/lv1224/article/details/79974175

/**
 * 思路：
 * 单调递增入栈，一但遇到小于栈顶元素的，以这个元素为挡板，分别计算栈顶元素到挡板元素的距离*栈顶元素高度
 * 因为递增，所以从前往后算，后边的一定大于前边的值，所以可以使用前边的值作为高，举个例子
 * 当前栈元素1、5、6 遇到2。那么以2作为挡板元素
 * 第一次计算 1*6 = 6 元素6距离元素2 1个距离
 * 第二次计算 2*5 = 10 元素5距离元素2 2个距离，6比5大，所以可以使用5作为高
 */
public class LeetCode_84 {

    public int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> indexs = new Stack<>();
        int area = 0;
        for(int i=0;i<heights.length;i++){
            if(indexs.isEmpty() || heights[indexs.peek()]<heights[i]){
                indexs.push(i);
            }else {
                while(!indexs.isEmpty() && heights[indexs.peek()]>=heights[i]){
                    int temp = indexs.pop();
                    int length = indexs.isEmpty()?i:i-indexs.peek()-1;
                    System.out.println("1 pre area:"+area+",heights[temp]:"+heights[temp]+",length:"+length);
                    area = Math.max(area,heights[temp]*length);

                }
                indexs.push(i);
            }
        }
        while (!indexs.isEmpty()){
            int tmp = indexs.pop();
            int length = indexs.isEmpty()?n:n-indexs.peek()-1;
            System.out.println("2 pre area:"+area+"tmp:"+tmp+",heights[temp]:"+heights[tmp]+",length:"+length);
            area = Math.max(area,length*heights[tmp]);
        }
        return area;
    }

    public static void main(String[] args) {
        LeetCode_84 leetCode_84 = new LeetCode_84();
        int[] testData = {2,1,5,6,2,3};
        leetCode_84.largestRectangleArea(testData);
    }
}
