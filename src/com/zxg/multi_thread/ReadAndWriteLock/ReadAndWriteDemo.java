package com.zxg.multi_thread.ReadAndWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Java读写锁的使用方式
 */
public class ReadAndWriteDemo {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private String fileData = "";

    public void readFlie(){
        //读锁上锁
        lock.readLock().lock();
        //模拟读取文件
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ ":正在进行读操作……");
        }
        System.out.println(Thread.currentThread().getName() + ":读操作完毕！");
        //释放锁
        lock.readLock().unlock();
    }
    public void writeFile(String data) {
        //写锁上锁
        lock.writeLock().lock();
        //模拟写文件
        for(int i=0;i<5;i++){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":正在进行写操作");
        }
        fileData += data;
        System.out.println(Thread.currentThread().getName()+"data:"+fileData);
        //释放锁
        lock.writeLock().unlock();
    }

    public static void main(String[] args) {
        /**
         * 从以下代码执行结果可以看出
         * 在某一线程读的过程中，另外一条读线程是可以进入到readFile方法进行读取的
         * 在某一线程写的过程中，不允许有另外一条读或写线程进入到writeFile方法
         * 可重入方面：
         * 内部的WriteLock可以获取ReadLock，但是ReadLock内部不可以获取到WriteLock
         */
        ReadAndWriteDemo demo = new ReadAndWriteDemo();
        for(int i=0;i<5;i++){
            new Thread(){
                @Override
                public void run() {
                    demo.readFlie();
                }
            }.start();
            new Thread(){
                @Override
                public void run() {
                    demo.writeFile("test");
                }
            }.start();
        }
    }
}
