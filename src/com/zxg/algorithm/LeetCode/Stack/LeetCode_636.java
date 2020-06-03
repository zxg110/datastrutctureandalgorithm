package com.zxg.algorithm.LeetCode.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 先减后加 这个思路确实没想到
 */
public class LeetCode_636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if ("start".equals(split[1])) {
                stack.push(new int[]{id, time});
            } else {
                int[] pop = stack.pop();
                int interval = time - pop[1] + 1;
                System.out.println("before pop[0]:"+pop[0]+",res[pop[0]]"+res[pop[0]]);
                res[pop[0]] += interval;
                System.out.println("after pop[0]:"+pop[0]+",res[pop[0]]"+res[pop[0]]);
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] = res[stack.peek()[0]] - interval;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_636 leetCode_636 = new LeetCode_636();
        List<String> test = new ArrayList<>();
        test.add("0:start:0");
        test.add("1:start:2");
        test.add("1:end:5");
        test.add("0:end:6");
        int[] result = leetCode_636.exclusiveTime(2,test);
        System.out.println(Arrays.toString(result));
    }

}
