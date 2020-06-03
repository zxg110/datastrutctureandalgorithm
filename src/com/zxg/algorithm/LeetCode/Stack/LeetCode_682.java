package com.zxg.algorithm.LeetCode.Stack;

import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode_682 {

    public int calPoints(String[] ops) {
        Stack<Integer> numStack = new Stack<>();
        String op;
        for (int i = 0; i < ops.length; i++) {
            op = ops[i];
            if (op.matches("-?\\d+"))
                numStack.push(Integer.parseInt(op));

                //cut off the point in last round
            else if (op.equals("C") || op.equals("c"))
                numStack.pop();
                //double the point in last round
            else if (op.equals("D") || op.equals("d")) {
                int top = numStack.peek();
                numStack.push((top << 1));
            }
            //add the last two round numbers
            else if (op.equals("+")) {
                int top = numStack.pop();
                int stop = numStack.peek();
                numStack.push(top);
                numStack.push(top + stop);
            }
            //go cycling if not reach the end
            else
                continue;
        }
        int totalPoints = 0;
        Iterator<Integer> iterator = numStack.iterator();
        while (iterator.hasNext()) {
            totalPoints += iterator.next();
        }
        return totalPoints;
    }



    public static void main(String[] args) {
        LeetCode_682 leetCode_682 = new LeetCode_682();
        String[] test = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(leetCode_682.calPoints(test));
    }

}
