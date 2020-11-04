package com.jwj.study.netty.publishandsubscribe;

import java.util.Observable;

/**
 * @Author: jwj
 * @Date: 2020/8/17 11:20
 * @Description: TODO
 */
public class NumPublish extends Observable {

    private Integer num;

    public void iChanged(int i){
        if (i%2!=0){
            System.out.println("发布方："+i+" 不是偶数，不通知订阅者！");
            this.clearChanged();
        }else {
            this.setChanged();
            System.out.println("发布方："+i+" 是偶数，通知订阅者！");
        }
        this.notifyObservers(i);
//        this.clearChanged();
    }
}
