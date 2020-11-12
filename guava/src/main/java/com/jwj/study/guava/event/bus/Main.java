package com.jwj.study.guava.event.bus;

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jwj
 * @date 2020/11/5 13:54
 * @description TODO
 * @since TODO
 */
public class Main {
    public static void main(String[] args) {
        EventBus eventBus=new EventBus();
        EventBusChangeListener listener1=new EventBusChangeListener("1号");
        EventBusChangeListener listener2=new EventBusChangeListener("2号");
        eventBus.register(listener2);
        eventBus.register(listener1);
        List<String> messages=new ArrayList<String>(Arrays.asList("3"));
        eventBus.post(messages);
        eventBus.unregister(listener1);
        eventBus.post(messages);
    }
}
