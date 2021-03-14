package com.jwj.concurrency.in.practice;

import java.util.concurrent.CountDownLatch;

/**
 * 测试CountDownLatch
 * 本类会创建一定数量的线程，利用它们并发的执行任务，并统计消耗的时间
 * 闭锁1：表示起始门，初始值为1
 * 闭锁2：表示结束门，初始值为工作线程的数量
 * @author jiangwenjie
 * @since 1.0
 */
public class TestHarness {

    public long timeTasks(int nThreads,final Runnable task) throws InterruptedException {
        final CountDownLatch startGate=new CountDownLatch(1);
        final CountDownLatch endGate=new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Runnable r= (Runnable) () -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t=new Thread(r);
            t.start();
        }
        long start=System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end=System.nanoTime();
        return end-start;
    }

    public static void main(String[] args) throws InterruptedException {
        TestHarness harness=new TestHarness();
        Runnable r= () -> {
            try {
                System.out.println("睡了");
                Thread.sleep(1000);
                System.out.println("醒了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        System.out.println("耗时 "+harness.timeTasks(10,r));
    }
}
