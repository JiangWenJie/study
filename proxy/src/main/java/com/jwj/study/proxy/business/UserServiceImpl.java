package com.jwj.study.proxy.business;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class UserServiceImpl implements IUserService{

    @Override
    public String add(String name) {
        System.out.println("add方法创建了一个用户: "+name);
        return name;
    }
}
