package com.jwj.concurrency;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

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
