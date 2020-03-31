package com.zxg.future;

import java.util.concurrent.*;

public class CompletableFutureTest {

    static class Student {
        int no;
        String name;

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Student(int no, String name) {
            this.no = no;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        testFuture();
    }

    public interface SimpleCallback {
        void onDataReady(int data);
    }

    private static void testFuture2() {
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        CompletableFuture<Student> s1 = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("task 1 thread:" + Thread.currentThread());
                    return new Student(1, "zxg");
                }, singlePool)
                .thenApplyAsync(s -> {
                    s.name = "ddf";
                    System.out.println("task 2 thread:" + Thread.currentThread() + ",stu:" + s.toString());

                    return s;
                }, singlePool)
                .thenApplyAsync(s -> {
                    System.out.println("task 3 thread:" + Thread.currentThread() + ",stu:" + s.toString());
                    s.name = "ggg";
                    return s;
//                    throw new NullPointerException();
                }).whenComplete((s, e) -> {
                    System.out.println("when complete s:" + s.toString());
                })
                .exceptionally(throwable -> {
                    System.out.println("task 4 thread:" + Thread.currentThread());
                    System.out.println(throwable.toString());
                    return null;
                });
        try {
            System.out.println("main stu:" + s1.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void testFuture() {
        ExecutorService singlePool = Executors.newSingleThreadExecutor();
        CompletableFuture<Future<Student>> s1 = CompletableFuture.supplyAsync(() ->
                        wrapperMockNetwork()
                , singlePool).thenApplyAsync(s -> {
            try {
                Student stu = s.get();
                System.out.println("main stu:" + stu.name);
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                return null;
            }
        }, singlePool);
    }

    private static Future<Student> wrapperMockNetwork() {
        Future<Student> future = new CompletableFuture<>();
        mockNetwork(new SimpleCallback() {
            @Override
            public void onDataReady(int data) {
                Student stu = new Student(data, "343");
                ((CompletableFuture<Student>) future).complete(stu);
            }
        });
        return future;
    }

    private static void mockNetwork(SimpleCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    callback.onDataReady(123);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
