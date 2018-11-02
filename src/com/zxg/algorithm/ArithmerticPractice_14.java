package com.zxg.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手上没牌，最后桌子上的牌是从1到n有序，设计程序，输入n，输出牌堆的顺序数组
 */
public class ArithmerticPractice_14 {

    public static void calculate(int n) {
        int[] a = new int[0];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i + 1;
        }
        reverse(a, b);
    }

    private static void reverse(int[] a, int[] b) {
        a = Arrays.copyOf(a, a.length + 1);
        System.arraycopy(a, 0, a, 1, a.length - 1);
        a[0] = b[b.length - 1];
        b = Arrays.copyOf(b, b.length - 1);
        if (0 == b.length) {
            System.out.println(Arrays.toString(a));
            return;
        }
        int cmp = a[a.length - 1];
        System.arraycopy(a, 0, a, 1, a.length - 1);
        a[0] = cmp;
        reverse(a, b);
    }

    private static int[] reverse(int[] orderArray){
        //最终要反推的结果数组
        int[] result = new int[2];
        result[0] = orderArray[orderArray.length-1];
        result[1] = orderArray[orderArray.length-2];
        for(int i=orderArray.length-3;i>=0;i--){
            //从桌上牌堆顶取一张牌
            int cur = orderArray[i];
            //扩容手里牌堆
            result = Arrays.copyOf(result,result.length+1);
            //把桌上取到的牌放入手里牌堆堆顶
            result[result.length-1] = cur;
            //保存手里堆顶的牌
            int temp = result[result.length-1];
            //将手里牌堆全部向后移动1位，
            System.arraycopy(result,0,result,1,result.length-1);
            result[0] = temp;
        }
        return result;

    }

    public static int[] getOrder(int n){
        //1~n顺序数组
        int[] orderArray = new int[n];
        for(int i=0;i<n;i++){
            orderArray[i] = i+1;
        }
        return reverse(orderArray);

    }




    public static void main(String[] args) {
//        List list = new ArrayList();
//        List intList = new ArrayList();
//        intList.add(1);
//        intList.add(2);
//        intList.add(3);
//        intList.add(4);
//        intList.add(5);
//
//        List aaa = aaa(intList, new ArrayList(), list, true);
//        System.out.println(aaa);

//        calculate(5);
        System.out.println( Arrays.toString(getOrder(5)));



    }


}
