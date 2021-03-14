package com.jwj.concurrency.in.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用循环屏障实现一个当多个线程一起到达再执行的程序
 * CountDownLatch和CyclicBarrier的比较
 *  1.CountDownLatch是线程组之间的等待，即一个(或多个)线程等待N个线程完成某件事情之后再执行；而CyclicBarrier则是线程组内的等待，即每个线程相互等待，即N个线程都被拦截之后，然后依次执行。
 *  2.CountDownLatch是减计数方式，而CyclicBarrier是加计数方式。
 *  3.CountDownLatch计数为0无法重置，而CyclicBarrier计数达到初始值，则可以重置。
 *  4.CountDownLatch不可以复用，而CyclicBarrier可以复用。
 * @author jiangwenjie
 * @since 1.0
 */
public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board board){
        this.mainBoard=board;
        int count=Runtime.getRuntime().availableProcessors();
        this.barrier=new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
        });
        this.workers=new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i]=new Worker(mainBoard.getSubBoard(count,i));
        }
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board){
            this.board=board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()){
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x,y,computeValue(x, y));
                    }
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private int computeValue(int x, int y) {
            // Compute the new value that goes in (x,y)
            return 0;
        }
    }
    interface Board {
        int getMaxX();
        int getMaxY();
        int getValue(int x, int y);
        int setNewValue(int x, int y, int value);
        void commitNewValues();
        boolean hasConverged();
        void waitForConvergence();
        Board getSubBoard(int numPartitions, int index);
    }
}
