package com.zxg.algorithm;
/**
 * Created by zengxiangge on 2018-4-20.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ArithmerticPractice_10 {
    public static String exchangeString(String source,String target,String exchange){
        StringBuffer sb_2 = new StringBuffer();
        for(int i=0;i<source.length();i++){
            if(String.valueOf(source.charAt(i)).equals(exchange)){
                sb_2.append(target);
            }else {
                sb_2.append(source.charAt(i));
            }
        }
        return sb_2.toString();
    }
    public static void main(String[] args) {
        System.out.println("result:"+exchangeString("we are happy","%20"," "));
    }
}
