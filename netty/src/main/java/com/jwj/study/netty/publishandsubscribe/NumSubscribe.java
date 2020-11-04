package com.jwj.study.netty.publishandsubscribe;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: jwj
 * @Date: 2020/8/17 11:25
 * @Description: TODO
 */
public class NumSubscribe implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("订阅方：收到通知了,i是 "+(int)arg);
    }
}
