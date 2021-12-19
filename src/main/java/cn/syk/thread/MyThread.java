package cn.syk.thread;

import cn.syk.config.BaseConfigValues;

import java.util.concurrent.*;

/**
 * @Author syk
 * @date 2021/12/1 17:06
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        BaseConfigValues baseConfigValues = new BaseConfigValues();
//        创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
        ExecutorService executor = Executors.newFixedThreadPool(100);
//        创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
//        线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
        ExecutorService executor1 = Executors.newCachedThreadPool();
//        创建一个定长线程池，支持定时及周期性任务执行。
        ExecutorService executor2 = Executors.newScheduledThreadPool(10);
//        创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        for (int i = 0; i <500000 ; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    baseConfigValues.setCount();
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.out.println("执行结果：count=" + baseConfigValues.getCount());
    }
}

