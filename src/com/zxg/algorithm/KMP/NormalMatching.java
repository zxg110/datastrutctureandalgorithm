package com.zxg.algorithm.KMP;

/**
 * 字符串匹配的普通算法：在目标字串中找到与匹配字串相等的字串，若找到
 * 返回目标字串匹配的小标，否则，返回-1
 */
public class NormalMatching {
    public int match(String targetStr, String matchStr) {
        for (int i = 0; i < targetStr.length()-matchStr.length()+1; i++) {
            for (int j = 0; j < matchStr.length(); j++) {
                char targetChar = targetStr.charAt(i + j);
                char matchChar = matchStr.charAt(j);
                if (matchChar != targetChar) {
                    //如果发现不匹配，没必要接着内循环了，跳出内循环，外循环将targetStr+1进入内循环再匹配
                    break;
                } else {
                    //如果字符匹配，判断j是否等于matchStr-1，若相等，
                    //则说明内循环结束，字符均匹配，return true，否则接着内循环匹配
                    if (j == matchStr.length() - 1) {
                        return i;
                    } else {
                        //
                        continue;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String targetStr = "absdfcab";
        String matchStr = "cab";
        NormalMatching matching = new NormalMatching();
        System.out.println(matching.match(targetStr, matchStr));
    }
}
