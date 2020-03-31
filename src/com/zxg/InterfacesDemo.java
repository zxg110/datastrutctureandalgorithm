package com.zxg;

import java.util.ArrayList;
import java.util.List;

public class InterfacesDemo {

    public static void main(String[] args) {
        //财会人员计算每角色的工资
        //计算方法：工作年限*基本工资*学历 计算对象人员:Coder pro manager
        List<IPayBasis> pay = new ArrayList<>();

        for(IPayBasis item:pay){
            int result = item.money()*item.year()*item.Education();
            System.out.printf("name:"+item.name()+",result money:"+result);
        }

        //高级管理者开始工作
        SeniorManager seniorManager = new SeniorManager();
        //开会
        seniorManager.meeting();
    }

}

interface IPayBasis{
    String name();
    int year();
    int money();
    int Education();
}

class SeniorManager extends Manager implements IPayBasis{

    void yingchou(){

    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public int year() {
        return 4;
    }

    @Override
    public int money() {
        return 340000;
    }

    @Override
    public int Education() {
        return 0;
    }

}

getAnquanDataByIndex

interface Anquan{

}

class Manager implements IPayBasis{

    void manag(){

    }

    void meeting(){
        System.out.println("上午十点开会");
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public int year() {
        return 4;
    }

    @Override
    public int money() {
        return 340000;
    }

    @Override
    public int Education() {
        return 0;
    }
}

class Coder implements IPayBasis{

    void code(){

    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public int year() {
        return 0;
    }

    @Override
    public int money() {
        return 0;
    }

    @Override
    public int Education() {
        return 0;
    }
}
