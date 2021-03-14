package com.jwj.study.netty.rpc.producer;

import com.jwj.study.netty.rpc.service.HelloService;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String me) {
        String result="hello "+me+" !";
        System.out.println(result);
        return result;
    }
}
