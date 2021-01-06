package com.jwj.study.data.structure.queue;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayQueueTest {
    IMyQueue myQueue;

    @Before
    public void setUp() throws Exception {
        myQueue=new MyArrayQueue(16);
    }

    @Test
    public void testLoop(){
        for (int i = 0; i < 15; i++) {
            myQueue.enQueue(i);
        }
        myQueue.output();
        System.out.println("出队的值="+myQueue.deQueue());
        System.out.println("出队的值="+myQueue.deQueue());
        System.out.println("出队的值="+myQueue.deQueue());
        myQueue.output();
        myQueue.enQueue(99);
        myQueue.enQueue(98);
        myQueue.enQueue(97);
        myQueue.output();
    }

    @Test
    public void testDeNullQueue(){
        myQueue.deQueue();
    }

    @Test
    public void testEnFullQueue(){
        for (int i = 0; i < 17; i++) {
            myQueue.enQueue(i);
        }
    }
}
