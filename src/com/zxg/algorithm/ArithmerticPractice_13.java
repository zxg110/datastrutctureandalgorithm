package com.zxg.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 删除ArrayList中重复的元素
 * 如果我们在for循环中遍历删除，则会出现循环错乱的问题，因为当删除某一项后，size()改变，有可能导致
 * 没有遍历到最后一项，所以要另想方案
 * 1、采用HashSet：不允许重复元素；不保持插入顺序，这种方法需要重写equals和hashCode
 * 2、采用LinkHashSet：不允许重复元素并保持插入顺序,同样，这种方法需要重写equals和hashCode
 * 3、采取双层循环
 * 4、遍历时更新size与i
 */
public class ArithmerticPractice_13 {
    public static void main(String[] args) {
        ArrayList<NetWork> netWorkArrayList = new ArrayList<>();
        NetWork n1 = new NetWork("1","192");
        NetWork n2 = new NetWork("1","192");
        NetWork n3 = new NetWork("1","193");
        NetWork n4 = new NetWork("1","192");
        NetWork n5 = new NetWork("1","195");
        NetWork n6 = new NetWork("1","192");
        netWorkArrayList.add(n1);
        netWorkArrayList.add(n2);
        netWorkArrayList.add(n3);
        netWorkArrayList.add(n4);
        netWorkArrayList.add(n5);
        System.out.println(netWorkArrayList);
        LinkedHashSet<NetWork> linkedHashSet = new LinkedHashSet<>(netWorkArrayList);
        System.out.println("after linedHashSet keep sort:"+linkedHashSet);
        HashSet<NetWork> hashSet = new HashSet<>(netWorkArrayList);
        System.out.println("after HashSet not keep sort:"+hashSet);
        /**
         * 从尾部开始逐一比较，这样一旦某一个元素符号要求，需要delete，
         * 能保证删除尾部之上的，不会造成循环错乱。
         */
        for(int i=0;i<netWorkArrayList.size()-1;i++){
            for(int j=netWorkArrayList.size()-1;j<=0;j--){
                if(netWorkArrayList.get(j).getAddress().equals(netWorkArrayList.get(i).getAddress())){
                    netWorkArrayList.remove(j);
                }
            }
        }


    }

}
class NetWork{
    private String id;
    private String address;

    public NetWork(String id, String address) {
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "id="+id+";address:"+address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        return address.equals(((NetWork)obj).getAddress());
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
}