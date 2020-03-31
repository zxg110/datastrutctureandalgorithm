package com.zxg.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个数组 去重，不用HashSet等数据结构的特性
 */
public class ArithmerticPractice_15 {

    public static void mergeArray(){
        List<String> repeatList = new ArrayList<>();
        String[] strArr1 = {"12","13","15","16"};
        String[] strArr2 = {"9","15","12","19"};
        for(int i=0;i<strArr1.length;i++){
            for(int j=0;j<strArr2.length;j++){
                if(strArr1[i].equals(strArr2[j])){

                }else {

                }
            }
        }



    }
}
