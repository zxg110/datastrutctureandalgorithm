package com.zxg.future;

import java.util.concurrent.*;

/**
 * https://blog.csdn.net/Holmofy/article/details/82714665
 * https://www.cnblogs.com/lixuwu/p/7979480.html
 * <p>
 * 理解为一个线程池
 * ThreadPoolExecutor中每个任务都是由单个线程独立处理的，如果出现一个非常耗时的大任务(比如大数组排序)，
 * 就可能出现线程池中只有一个线程在处理这个大任务，而其他线程却空闲着，这会导致CPU负载不均衡：空闲的处理器
 * 无法帮助工作繁忙的处理器。
 * <p>
 * ForkJoinPool就是用来解决这种问题的：将一个大任务拆分成多个小任务后，
 * 使用fork可以将小任务分发给其他线程同时处理，使用join可以将多个线程处理的结果进行汇总；
 * 这实际上就是分治思想的并行版本。
 */
public class ForkJoinPoolTest {
    //创建ForkJoin的方式
    //构造
    private ForkJoinPool forkJoinPool = new ForkJoinPool();
    //拿common
    private ForkJoinPool commonForkJoinPool = ForkJoinPool.commonPool();
    //通过ExecuteService拿
    private ForkJoinPool forkJoinPool2 = (ForkJoinPool) Executors.newWorkStealingPool();

    /**
     * 向forkJoinPool中提交无返回值的任务，注意提交到forkJoinPool的任务最终都会转化为
     * ForkJoinTask
     *
     * @param task
     */
    public void exectue(ForkJoinTask<?> task) {
        if (forkJoinPool != null) {
            forkJoinPool.execute(task);
        }

    }

    /**
     * 向forkJoinPool中提交无返回值的任务，注意提交到forkJoinPool的任务最终都会转化为
     * ForkJoinTask
     *
     * @param task
     */
    public ForkJoinTask submit(ForkJoinTask<?> task) {
        if (forkJoinPool != null) {
            return forkJoinPool.submit(task);
        }
        return null;
    }

    /**
     * 一般我们不直接使用ForkJoinTask，而是使用它的两个抽象类
     * RecursiveAction无返回值
     */
    static class Sorter extends RecursiveAction {
        @Override
        protected void compute() {

        }
    }

    /**
     * RecursiveTask 有返回值
     */
    static class Sum extends RecursiveTask<Long> {

        @Override
        protected Long compute() {
            return null;
        }
    }


}
