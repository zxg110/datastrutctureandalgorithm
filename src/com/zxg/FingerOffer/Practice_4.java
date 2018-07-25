package com.zxg.FingerOffer;

/**
 * 位运算
 * &：0&0=0 0&1=0 1&0=0 1&1=1
 * |：0|0=0 0|1=1 1|0=1 1|1=1
 * ^：0^0=0 0^1=1 1^0=1 1^1=0
 * >> 右移 舍弃右边，如果是无符号数字左边补0，若是有符号数字，左边补符号位
 * 无符号：0000 1010 >> 2 = 0000 0010
 * 有符号：1000 1010 >> 2 = 1110 0010
 * 0000 1010 >> 2 = 0000 0010
 * << 左移 向左进位 右边补0  0000 1010 << 2 = 0010 1000
 * 给定一个十进制数，输出其二进制表示中1的个数
 */
public class Practice_4 {
    public static void main(String[] args) {
        System.out.println("result:" + count_1(9));
    }

    /**
     * 该解法若遇到负数，右移，右边补齐的是1，那么最后会变成全是1，进入死循环
     * @param n
     * @return
     */
    public static int count(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    /**
     * 把整数减一，与原来做与运算
     */
    public static int count_1(int n){
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);//每次都消除该数中最右边的1
        }
        return count;
    }
}
