package com.zxg.multi_thread;

public class SerialThreadDemo_2 {
    static int i=0;
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                add();
            }
        });
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    //引用t1线程，等待t1线程执行完
//                    t1.start();
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
            }
        });
        Thread t3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    /**
                     * 引用t2，t2.start()可以放在主线程中进行，因为虽然t2.start()可能先运行
                     * 但是t2.run()中第一步是t1.join()保证t1运行。随后才进行逻辑方法add()
                     * 即使调用了t1.join()时，还未调用到t1.run()也会进行等待。
                     */
  //                  t2.start();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
            }
        });


        t1.start();
        t2.start();
        t3.start();
    }
    public static void add(){
        System.out.println("add start in thread name:"+Thread.currentThread().getName()+",i:"+i);
        i++;
        System.out.println("add end in thread name:"+Thread.currentThread().getName()+"，i:"+i);
    }
}
