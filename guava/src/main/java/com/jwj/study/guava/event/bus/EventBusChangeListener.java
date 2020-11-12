package com.jwj.study.guava.event.bus;

import com.google.common.eventbus.Subscribe;

import java.util.List;

/**
 * @author jwj
 * @date 2020/11/5 14:07
 * @description TODO
 * @since TODO
 */
public class EventBusChangeListener {

    private String name;

    public EventBusChangeListener(String name) {
        this.name = name;
    }

    @Subscribe
    public void handleEventBusChange(List<String> messages){
        for (String msg:messages) {
            System.out.println("我("+this.name+")收到了消息:"+msg);
            if (msg.equals("3")){
                throw new IllegalArgumentException();
            }
        }
    }
}
