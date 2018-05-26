package com.zxg.datastructure;



public class FileClassLoader {


    public static void main(String[] args) throws ClassNotFoundException {

//        FileClassLoader loader1 = new FileClassLoader(rootDir);
        ClassLoader classLoader = FileClassLoader.class.getClassLoader();
        System.out.println("自定义类加载器的父加载器: "+classLoader.getParent());
        System.out.println("系统默认的AppClassLoader: "+ClassLoader.getSystemClassLoader());
        System.out.println("AppClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent());
        System.out.println("ExtClassLoader的父类加载器: "+ClassLoader.getSystemClassLoader().getParent().getParent());

        /**
         输出结果:
         自定义类加载器的父加载器: sun.misc.Launcher$AppClassLoader@29453f44
         系统默认的AppClassLoader: sun.misc.Launcher$AppClassLoader@29453f44
         AppClassLoader的父类加载器: sun.misc.Launcher$ExtClassLoader@6f94fa3e
         ExtClassLoader的父类加载器: null
         */

    }
}