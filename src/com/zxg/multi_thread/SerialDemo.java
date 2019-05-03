package com.zxg.multi_thread;

/**
 * 三个线程串行执行
 * 在当前线程thread_1中调用thread_2.join()方法的效果是：thread_2.run()方法正常执行,无限期阻塞当前线程thread_1，直到thread_2.join()运行完毕。
 * 此例中，在主线程中先调用thread_1.start()后立马调用thread_1.join()，那么主线程就会阻塞直到thread_1执行完毕。当thread_1执行完毕，
 * 主线程才会接着向下走调用thread_2.start()，这就保证了thread_2一定是在thread_1完全执行后再执行
 */
public class SerialDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        SerialThread serialThread_1 = new SerialThread("thread_1");
        SerialThread serialThread_2 = new SerialThread("thread_2");
        SerialThread serialThread_3 = new SerialThread("thread_3");
        serialThread_1.start();
        serialThread_1.join();
        serialThread_2.start();
        serialThread_2.join();
        serialThread_3.start();
        serialThread_3.join();
        System.out.println("main thread end");

    }

}

class SerialThread extends Thread {
    private String name;

    public SerialThread(String name) {
        this.name = name;
    }

    static int i = 0;

    @Override
    public void run() {
        System.out.println("SerialThread run start name:" + name + ",i=" + i);
        i++;
        System.out.println("SerialThread run end" + name + ",i=" + i);

    }
}