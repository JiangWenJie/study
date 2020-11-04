package com.jwj.study.netty.event;

import java.util.EventObject;

/**
 * @Author: jwj
 * @Date: 2020/8/17 11:53
 * @Description: TODO
 */
public class HungryEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public HungryEvent(Object source) {
        super(source);
    }
}
