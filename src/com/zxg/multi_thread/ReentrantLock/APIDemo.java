package com.zxg.multi_thread.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrant API
 * int getHoldCount() 查询当前线程保持此锁的个数，也就是返回当前线程调用lock()的次数
 * int getQueueLength() 查询等待该锁的线程数
 * int getWaitQueueLength(Condition condition) 查询与此锁给定条件的Condition线程估计数
 * boolean hasQueuedThread(Thread thread) 查询指定的线程是否在等待该锁
 * boolean hasQueuedThreads() 查询是否有线程等待该锁
 * boolean hasWaiters(Condition condition) 查询有与此锁给定条件的Condition的线程
 * boolean isHeldByCurrentThread() 查询当前线程是否持有该锁
 * boolean isLocked() 查询该锁是否有线程锁定
 */
public class APIDemo {
    private ReentrantLock lock = new ReentrantLock();
    public void lockFirstTime(){
        lock.lock();
        System.out.println("first lock getHoldCount:"+lock.getHoldCount());
    }

    public void lockSecondTime(){
        lock.lock();
        System.out.println("second lock getHoldCount:"+lock.getHoldCount());
    }

    public void lock(){
        lock.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"抢占到锁");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final APIDemo demo = new APIDemo();
//        demo.lockFirstTime();
//        demo.lockSecondTime();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                demo.lock();
            }
        };
        Thread[] threads = new Thread[5];
        for(int i=0;i<5;i++){
            threads[i] = new Thread(runnable);
        }
        for (int i=0;i<5;i++){
            threads[i].start();
        }
        Thread.sleep(2000);
        System.out.println("有"+demo.lock.getQueueLength()+"个线程等待锁");
    }
}
