package com.zxg.multi_thread;

public class CountDemo {

    static class MyThread extends Thread{
        private static int count = 5;
        public MyThread(String name){
            super();
            this.setName(name);
        }

        @Override
        public void run() {
            super.run();
                count --;
                System.out.println("name:"+getName()+"count="+count);

        }
    }

    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();

    }
}
