package com.zxg.lambda;

import java.util.function.Function;

/**
 * 函数式接口Demo
 * Java 8中有很多自带的函数式接口，他们仅有一个抽象方法，其方法名
 * 体现了该接口的作用。同时包含一些已实现的方法，来提供操作。在定义Lambda
 * 表达式时，其表达式的逻辑正是实现了这些方法
 */
public class FunctionalInterfaceDemo {

    /**
     * Function接口
     * method实现了Function唯一的抽象方法apply逻辑是x+"abc"
     * 我们为什么要使用Function接口，而不是自己定义一个函数式接口呢？
     * 1、Java自带的函数式接口会有一些已实现的逻辑方法，来操控抽象方法
     * 2、相当于定义了一个标准，很多api可以将这些函数式接口作为入参
     */

    Function<Integer, String> method = x -> x + "123";

    public void testFunction(Integer originalParam) {

        method.apply(originalParam);
        //例如，Function提供了andThen方法，该方法接收一个lambda
        //在执行apply()方法后执行andThen的lambda。参数为apply的结果(string)
        Integer y = method.andThen(x ->
                Integer.valueOf(x)+1).apply(originalParam);
        /**
         * andThen在method执行，method的输出作为andThen中lambda的输入即可，对andThren
         * 中lambda的输出没有限制
         */
        System.out.println("result y:" + y);
        Function<Integer, Integer> squared = x -> x * x;
        /**
         * 这里和andThen有个区别
         * compose的输入和输出参数的类型必须和method的输入一样
         * 我们看下执行流程：先将原始输入4执行squared函数，其执行输出(16)又作为
         * method的输入。可以理解为method的输入(Integer)先去去squared执行了一圈
         * 再执行method
         */
        System.out.println("result:" + method.compose(squared).apply(4));
    }

    public static void main(String[] args) {
        FunctionalInterfaceDemo demo = new FunctionalInterfaceDemo();
        demo.testFunction(5);
    }


}
