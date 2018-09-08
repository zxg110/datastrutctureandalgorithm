package com.zxg.multi_thread;

public class StopThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        NeedStopThread thread = new NeedStopThread();
        thread.start();
        //主线程sleep，此时子线程在运行
        Thread.sleep(300);
        //在主线程中调用thread.interrupt();中断该线程
        thread.interrupt();
        Thread.sleep(300);
        System.out.println("is interrupted:"+thread.isInterrupted());

    }
}

class NeedStopThread extends Thread {
    @Override
    public void run() {
        try {
            //这里可以直接写成while(!isInterrupted)为了打印这样写
            while (true) {
                //记录当前中断情况
                boolean isInterrupted = isInterrupted();
                System.out.println("isInterrupted:"+isInterrupted);
                if (!isInterrupted) {
                    //处理业务
                    Thread.sleep(5);
                }else{
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("catch e"+e.toString());
            //carry线程阻塞时，外部调用interrupt()抛出的interruptedException
        }

    }
}
