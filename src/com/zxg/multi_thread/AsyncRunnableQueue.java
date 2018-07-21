package com.zxg.multi_thread;

import java.util.concurrent.*;

public class AsyncRunnableQueue {
    private static class AsyncRunnableQueueHolder{
        private static final AsyncRunnableQueue INSTANCE = new AsyncRunnableQueue();
    }

    //维护一个阻塞队列
    LinkedBlockingQueue<Runnable> linkedBlockingQueue;
    //串行执行线程
    Thread thread;
    //并行执行线程池
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(12);
    //停止标志
    boolean isStop;

    private AsyncRunnableQueue(){
        linkedBlockingQueue = new LinkedBlockingQueue<>();
    }
    //单例模式维护
    public static final AsyncRunnableQueue getInstance(){
        return AsyncRunnableQueueHolder.INSTANCE;
    }

    public void addRunnable(Runnable runnable){
        if(linkedBlockingQueue != null){
            linkedBlockingQueue.offer(runnable);
        }
    }

    /**
     * 串行执行所有Runnable
     */
    public void runAllTaskSerial() {
        isStop = false;
        if (thread == null) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!isStop && linkedBlockingQueue.peek() != null) {
                        System.out.println("Serial thread name:"+Thread.currentThread().getName());
                        Runnable runnable = linkedBlockingQueue.poll();
                        runnable.run();
                    }
                }
            });
        }
        if (!isStop) {
            thread.start();
        }
    }

    /**
     * 并行执行runnable
     * 串行执行中所有的runnable均在一个线程中串行执行，若runnable是耗时任务，则需要开启多个线程并行执行
     * 这里我们使用线程池
     */
    public void runTaskParallel(){
        isStop = false;
        while(!isStop && linkedBlockingQueue.peek() != null){
            if(fixedThreadPool != null){
                fixedThreadPool.execute(linkedBlockingQueue.poll());
            }
        }
    }

    public void stop(){
        isStop = true;
    }
}
