package com.jwj.java.souce.code;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 可重入锁，非公平的实现
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class MyReentrantLock implements Lock {
    private final NonfairSync sync=new NonfairSync();

    @Override
    public void lock() {
        sync.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

    final class NonfairSync extends AbstractQueuedSynchronizer{
        void lock(){
            if (compareAndSetState(0,1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }

        @Override
        protected boolean tryAcquire(int acquires) {
            final Thread current=Thread.currentThread();
            int c=getState();
            if (c==0){
                if (compareAndSetState(0,acquires)){
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }else if (current==getExclusiveOwnerThread()){
                int nextc=c+acquires;
                if (nextc<0)
                    throw new Error("锁的数量已经达到最大值");
                setState(nextc);
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int releases){
            int c=getState()-releases;
            if (Thread.currentThread()!=getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free=false;
            if (c==0){
                free=true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }
}
