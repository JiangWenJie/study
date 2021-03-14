package com.jwj.concurrency.lock.support;

import java.sql.SQLOutput;
import java.util.concurrent.locks.LockSupport;

/**
 * 这里乱序使用park
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class UnParkAndParkDemo {
    public static void main(String[] args) throws InterruptedException {
        UnParkAndParkThread thread=new UnParkAndParkThread(Thread.currentThread());
        thread.start();
        Thread.sleep(3000);
        System.out.println("before park");
        LockSupport.park("UnParkAndParkDemo");
        System.out.println("after park");
    }
}
class UnParkAndParkThread extends Thread{
    private Thread object;

    public UnParkAndParkThread(Thread object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        LockSupport.unpark(object);
        System.out.println("after unpark");
    }
}
