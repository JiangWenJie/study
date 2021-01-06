package com.jwj.study.data.structure.queue;

import java.util.Arrays;

/**
 * @author jwj
 * @date 2021/1/6 15:45
 * @description 数组队列
 * @since 1.0
 */
public class MyArrayQueue implements IMyQueue {
    private int[] data;
    private int front;
    private int rear;

    public MyArrayQueue(int size) {
        this.data = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public int enQueue(int element) {
        if((rear+1)%data.length==front){
            throw new IndexOutOfBoundsException("队列已满");
        }
        data[rear]=element;
        rear=(rear+1)%data.length;
        return rear;
    }

    @Override
    public int deQueue() {
        if (front==rear){
            throw new IndexOutOfBoundsException("队列为空");
        }
        int result=data[front];
        front=(front+1)%data.length;
        return result;
    }

    @Override
    public String toString() {
        return "MyArrayQueue{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", rear=" + rear +
                '}';
    }

    @Override
    public void output() {
        System.out.println(toString());
    }
}
