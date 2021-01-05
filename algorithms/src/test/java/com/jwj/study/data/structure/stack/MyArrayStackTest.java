package com.jwj.study.data.structure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayStackTest {
    IMyStack stack=new MyArrayStack();

    @Test
    public void output() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.output();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.output();
    }
}
