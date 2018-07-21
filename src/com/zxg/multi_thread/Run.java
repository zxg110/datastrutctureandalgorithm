package com.zxg.multi_thread;


public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(500);
        myThread.interrupt();
        myThread.isInterrupted();
        myThread.interrupted();
        Thread.currentThread().isInterrupted();
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i =0;i<50000;i++){
            System.out.println("i="+i);
        }
    }
}
