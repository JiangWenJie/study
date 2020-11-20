package com.jwj.study.spring.application.transaction.cas;

import com.jwj.study.spring.application.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SequenceServiceTest extends BaseTest {

    @Autowired
    SequenceService sequenceService;

    private final int THREAD_SIZE=1000;

//    @Autowired
//    ExecutorService executorService;

    @Test
    public void test() throws InterruptedException {
        long startTime=System.currentTimeMillis();
        CountDownLatch countDownLatch=new CountDownLatch(THREAD_SIZE);
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        final Date currentDate=calendar.getTime();
        ExecutorService executor= Executors.newSingleThreadExecutor();

        for (int i = 0; i < THREAD_SIZE; i++) {
            executor.execute(() -> {
                try {
                    sequenceService.compareAndSet(currentDate);
                } catch (Exception e) {
                    countDownLatch.countDown();
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        executor.shutdown();
        countDownLatch.await();
        long endTime=System.currentTimeMillis();
        System.out.println("耗时 "+(endTime-startTime));
    }

}
