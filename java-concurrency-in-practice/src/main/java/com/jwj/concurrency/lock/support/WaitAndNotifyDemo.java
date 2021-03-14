package com.jwj.concurrency.lock.support;

/**
 * 使用wait和notify实现线程同步
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        WaitAndNotifyThread myThread=new WaitAndNotifyThread();
        synchronized (myThread){
            try {
                myThread.start();
                Thread.sleep(3000);
                System.out.println("before wait");
                myThread.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {

            }
        }
    }
}

class WaitAndNotifyThread extends Thread{
    @Override
    public void run() {
        synchronized (this){
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}
