package com.zxg.algorithm.practice;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.在遍历concurrentHashMap时可以删除item
 * 2.一个线程对ConcurrentHashMap增加数据，另外一个线程在遍历时就能获得
 * https://blog.csdn.net/zsigner/article/details/79340208
 * 3.get()操作不涉及锁操作
 * 4.put()/remove()涉及锁操作
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException{
        Map<String,String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("key1","value1");
        hashMap.put("key2","value2");
        hashMap.put("key3","value3");
        for(Map.Entry<String,String> entry:hashMap.entrySet()){
            String key = entry.getKey();
            if(key.equals("key2")){
                hashMap.remove(key);
            }
        }
        for(Map.Entry<String,String> entry:hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //------//
        Map<Long, String> conMap = new ConcurrentHashMap<Long, String>();
        for (long i = 0; i < 5; i++) {
            conMap.put(i, i + "");
        }

        Thread thread = new Thread(new Runnable() {
            public void run() {
                //先睡眠100毫秒，保证在另一个线程遍历时，进行put操作
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                conMap.put(100l, "100");
                System.out.println("ADD:" + 100);

            }

        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for (Iterator<Map.Entry<Long, String>> iterator = conMap.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<Long, String> entry = iterator.next();
                    System.out.println(entry.getKey() + " - " + entry.getValue());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        thread2.start();

        Thread.sleep(3000);
        System.out.println("--------");
        for (Map.Entry<Long, String> entry : conMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
