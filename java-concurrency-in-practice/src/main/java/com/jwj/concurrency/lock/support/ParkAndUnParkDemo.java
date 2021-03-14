package com.jwj.concurrency.lock.support;

import java.util.concurrent.locks.LockSupport;

/**
 * 使用LockSupport.park和LockSupport.unPark实现阻塞和唤醒
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class ParkAndUnParkDemo {
    public static void main(String[] args) {
        ParkAndUnParkThread thread=new ParkAndUnParkThread(Thread.currentThread());
        thread.start();
        System.out.println("before park");
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }

}
class ParkAndUnParkThread extends Thread{
    private Object object;

    public ParkAndUnParkThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Blocker info"+ LockSupport.getBlocker((Thread) object));
        LockSupport.unpark((Thread) object);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Blocker info "+ LockSupport.getBlocker((Thread) object));
        System.out.println("after unpark");
    }
}
