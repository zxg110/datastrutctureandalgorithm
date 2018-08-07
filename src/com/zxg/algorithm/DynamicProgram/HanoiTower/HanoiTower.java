package com.zxg.algorithm.DynamicProgram.HanoiTower;


public class HanoiTower {
    int level = 6;
    public static void main(String[] args) {
//        hanoi(3,'A','B','C');
        System.out.println("count:"+hanoiCount(3));
    }

    /**
     * @param n 汉诺塔的层数
     * @param x x柱 起点柱(A)
     * @param y y柱 目标柱(B)
     * @param z z柱 中转柱(C)
     * 其中 A B C 只是作为辅助思考
     */
    public static void hanoi(int n, char x ,char y ,char z){

        //H(0)=0
        if (n==0){
            //什么也不做
        }else {
            //递推公式：H(n)=H(n-1) + 1 + H(n-1)
            //将n-1个圆盘从x(原始柱)移动到z(目标是中间柱),y为中转柱(剩下一根柱子为辅助)
            hanoi(n-1,x,z,y); //----------------------->解出n-1层汉诺塔:H(n-1)

            //移动最大圆盘到目的柱
            System.out.println(x+"->"+y);//------------> 1

            //将n-1个圆盘从z移动到y,x为中转柱
            hanoi(n-1,z,y,x);//------------------------>解出n-1层汉诺塔:H(n-1)
        }
    }

    public static int hanoiCount(int n){
        int moveCount = 0;
        if(n == 0){
            return 0;
        }else {
            //递推公式：H(n)=H(n-1) + 1 + H(n-1)
            //将n-1个圆盘从x移动到z,y为中转柱
            moveCount += hanoiCount(n-1); //------------->解出n-1层汉诺塔:H(n-1)

            //移动最大圆盘到目的柱
            moveCount += 1; //---------------------------------> 1

            //将n-1个圆盘从z移动到y,x为中转柱
            moveCount +=hanoiCount(n-1);//--------------->解出n-1层汉诺塔:H(n-1)
        }
        return moveCount;
    }
}
