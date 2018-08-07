package com.zxg.algorithm.StringDeal.KMP;

import java.util.Arrays;

public class KMPMatching {

    private String targetStr;
    private String matchStr;
    private int[] next;

    public String getMatchStr() {
        return matchStr;
    }

    public void setMatchStr(String matchStr) {
        this.matchStr = matchStr;
    }

    public String getTargetStr() {
        return targetStr;
    }

    public void setTargetStr(String targetStr) {
        this.targetStr = targetStr;
    }

    /**
     * 计算匹配值
     * A return 0； AB return 0； AA return 1；ABA return 1；ABDAB return 2
     * @param str
     * @return
     */
    private int calculateMatchValue(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return 0;
        }
        if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1)) {
                return 1;
            }
            return 0;
        }
        int orginalStrLength = str.length();

         //长度递减的取前缀和后缀做比较，若相等直接返回长度
        for (int i = orginalStrLength - 1; i >= 0; i--) {
            String preStr = str.substring(0, i);
            String sufStr = str.substring(orginalStrLength - i, orginalStrLength);
            if (preStr.equals(sufStr)) {
                return preStr.length();
            }
        }
        return 0;
    }

    //计算Next数组
    private void calculateNextArr() {
        if (matchStr == null && matchStr.length() == 0) {
            return;
        }
        next = new int[matchStr.length()];
        for (int i = 0; i < matchStr.length(); i++) {
            String subString = matchStr.substring(0, i + 1);
            next[i] = calculateMatchValue(subString);
        }
    }

    //debug
    public void debugNextArr(){
        calculateNextArr();
        System.out.println("next arr:"+ Arrays.toString(next));
    }

    public int match() {
        if (targetStr == null || targetStr.length() == 0) {
            return -1;
        }
        if (matchStr == null || matchStr.length() == 0) {
            return -1;
        }
        int targetStrLength = targetStr.length();
        int matchStrLength = matchStr.length();
        calculateNextArr();
        int i = 0;
        while (i <= targetStrLength - matchStrLength + 1) {
            for (int j = 0; j < matchStrLength; j++) {
                char targetChar = targetStr.charAt(i + j);
                char matchChar = matchStr.charAt(j);
                if (matchChar != targetChar) {
                    //若不相等，则向前移动next[j]+1个位置
                    i = i + next[j] + 1;
                    break;
                } else {
                    //如果字符匹配，判断j是否等于matchStr-1，若相等，
                    //则说明内循环结束，字符均匹配，return true，否则接着内循环匹配
                    if (j == matchStr.length() - 1) {
                        return i;
                    } else {
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KMPMatching kmpMatching = new KMPMatching();
        kmpMatching.setTargetStr("ABCCACDAFVDABCAB");
        kmpMatching.setMatchStr("ABCA");
        kmpMatching.debugNextArr();
        System.out.printf("result:"+kmpMatching.match());
    }

}
