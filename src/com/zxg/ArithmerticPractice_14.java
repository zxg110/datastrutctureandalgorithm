package com.zxg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 删除ArrayList中某一元素
 */
public class ArithmerticPractice_14 {
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        /**
         * 方式1：错误的写法，当remove()一个元素后，后面的的元素会集体向前移动，这样删除掉的元素的下一个
         * 元素会移动到当前位置，但此位置已经循环过了，所以会漏掉该元素的循环，log如下：
         *init[a, b, b, b, a],i=0
         * init[a, b, b, b, a],i=1
         * after delete:[a, b, b, a]
         * init[a, b, b, a],i=2
         * after delete:[a, b, a]
         * result:[a, b, a]
         */
        installList();
        for(int i=0;i<list.size();i++){
            System.out.println("init"+list.toString()+",i="+i);
            if(list.get(i).equals("b")){
                //list.remove(i); 与list.remove(obj)同效果
                list.remove("b");
                System.out.println("after delete:"+list.toString());
            }
        }
        System.out.println("result:"+list.toString());

        installList();
        /**
         * 方式二：正确
         * ite.remove()不会像list.remove(index)删除会将后边的元素往前移，而是删除next()返回
         * 的元素。
         */
        for(Iterator<String> ite = list.iterator();ite.hasNext();){
            System.out.println("init iterator"+list.toString());
            String str = ite.next();
            if(str.equals("b")){
                ite.remove();
                System.out.println("after delete"+list.toString());
            }
        }
        System.out.println("result:"+list.toString());


    }
    private static void installList(){
        list.clear();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("a");
        list.add("a");
    }
}
