package com.jwj.study.proxy.jdk;

import com.jwj.study.proxy.business.IUserService;
import com.jwj.study.proxy.business.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class UserInvocationHandler implements InvocationHandler {
    private Object target;

    public UserInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始代理这个方法了:" + proxy.getClass().getName() + " " + method.getName() + " " + Arrays.toString(args));
        return method.invoke(target, args);
    }

    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        UserInvocationHandler handler = new UserInvocationHandler(userService);
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), userService.getClass().getInterfaces(), handler);
        String name=proxy.add("jwj");
        System.out.println(name);
    }
}
