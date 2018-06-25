package com.zxg.algorithm;

import java.util.Stack;

/**
 * 将栈A的元素移到栈B中
 */
public class AlgorithmPractice_12 {
    static Stack<String> originStack = new Stack<String>();
    static Stack<String> targetStack = new Stack<String>();

    public static void main(String[] args) {
        setOriginStackData();
        migrate();
        System.out.printf("print target data ======" + "\n");
        printTarget();

    }

    private static void setOriginStackData() {
        originStack.push("firstData");
        originStack.push("secondData");
        originStack.push("thirdData");
        originStack.push("fourthData");
        System.out.printf("print origin data ======" + "\n");
        printOrigin();

    }

    private static void migrate() {
        String temp = null;
        int originSize = originStack.size();
        for (int i = 0; i < originSize; i++) {
            temp = originStack.pop();
            for (int j = 0; j < originSize - i - 1; j++) {
                targetStack.push(originStack.pop());
            }
            originStack.push(temp);
            while (!targetStack.empty()) {
                originStack.push(targetStack.pop());
            }
        }
        while (!originStack.empty()) {
            targetStack.push(originStack.pop());
        }
    }

    private static void printOrigin() {
        for (String s : originStack) {
            System.out.printf("origin data:" + s + "\n");
        }
    }

    private static void printTarget() {
        for (String s : targetStack) {
            System.out.printf("origin data:" + s + "\n");
        }
    }
}
