package com.jwj.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class TimeRun {
    private static final ScheduledExecutorService cancelExec= Executors.newScheduledThreadPool(1);

    public static void timedRun(Runnable r, long timeout, TimeUnit unit){
        class RethrowableTask implements Runnable{

            @Override
            public void run() {
                try {
                    r.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        Thread taskThread=Thread.currentThread();
        cancelExec.schedule(taskThread::interrupt,timeout,unit);
        r.run();
    }
}
