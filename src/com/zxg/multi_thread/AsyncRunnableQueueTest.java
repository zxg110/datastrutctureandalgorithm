package com.zxg.multi_thread;

public class AsyncRunnableQueueTest {
    public static void main(String[] args) {
        AsyncRunnableQueue queue = AsyncRunnableQueue.getInstance();
        queue.addRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 1 currentThread:"+Thread.currentThread().getName());
            }
        });
        queue.addRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 2 currentThread:"+Thread.currentThread().getName());
            }
        });
        queue.addRunnable(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 3 currentThread:"+Thread.currentThread().getName());
            }
        });
        queue.runAllTaskSerial();
//        queue.runTaskParallel();
    }
}
