package com.jwj.concurrency.in.practice;

import java.math.BigInteger;

/**
 * 一个耗时的计算函数
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        return new BigInteger(arg);
    }
}
interface Computable <A, V> {
    V compute(A arg) throws InterruptedException;
}
