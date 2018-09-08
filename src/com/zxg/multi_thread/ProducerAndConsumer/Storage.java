package com.zxg.multi_thread.ProducerAndConsumer;

import java.util.LinkedList;

/**
 * 最坏情况下，notify()唤起的都是同类线程（消费唤起的都是消费，生产唤起的都是生产）可能造成假死
 * 所以线程都在wait()，解决办法就是采用notifyAll()
 */
public class Storage {
    // 仓库最大存储量
    private final int MAX_SIZE = 1;

    // 仓库存储的载体
    private LinkedList<Object> list = new LinkedList<Object>();

    // 生产产品
    public void produce(String producer) {
        synchronized (list) {
            // 如果仓库已满
            while (list.size() == MAX_SIZE) {
                System.out.println("仓库已满，【" + producer + "】： 暂时不能执行生产任务!");
                try {
                    // 由于条件不满足，生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 生产产品
            list.add(new Object());

            System.out.println("【" + producer + "】：生产了一个产品\t【现仓储量为】:" + list.size());
            /**
             * notifyAll()唤起全部阻塞线程，包括生产和消费线程，被唤起的线程又要共同抢占锁，
             * notify()唤醒一个线程,有可能唤起生产线程，有可能是消费线程
             */
            //list.notifyAll();
            list.notify();
        }
    }

    // 消费产品
    public void consume(String consumer) {
        synchronized (list) {
            //如果仓库存储量不足
            while (list.size() == 0) {
                System.out.println("仓库已空，【" + consumer + "】： 暂时不能执行消费任务!");
                try {
                    // 由于条件不满足，消费阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.remove();
            System.out.println("【" + consumer + "】：消费了一个产品\t【现仓储量为】:" + list.size());
            list.notify();
        }
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public static void main(String[] args) {
        Storage storage = new Storage();

        for(int i=0;i<=5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    storage.consume("consume thread");
                }
            }).start();;
        }
        for(int i=0;i<=5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    storage.produce("produce thread");
                }
            }).start();
        }
    }
}
