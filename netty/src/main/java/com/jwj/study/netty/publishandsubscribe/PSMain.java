package com.jwj.study.netty.publishandsubscribe;

/**
 * @Author: jwj
 * @Date: 2020/8/17 11:26
 * @Description: TODO
 */
public class PSMain {
    public static void main(String[] args) {
        NumPublish numPublish=new NumPublish();
        NumSubscribe numSubscribe=new NumSubscribe();
        numPublish.addObserver(numSubscribe);
        numPublish.iChanged(1);
        numPublish.iChanged(2);
        numPublish.iChanged(3);
        numPublish.iChanged(4);

    }
}
