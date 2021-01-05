package com.jwj.study.data.structure.stack;

import com.jwj.study.data.structure.array.IMyArray;
import com.jwj.study.data.structure.array.MyArray;

/**
 * @author jwj
 * @date 2021/1/5 14:08
 * @description 栈的数组实现
 * @since 1.0
 */
public class MyArrayStack implements IMyStack {

    private IMyArray array=new MyArray(16);
    private int size=0;

    @Override
    public void push(int element) {
        array.insert(element,size);
        size++;
    }

    @Override
    public void pop() {
        array.delete(size-1);
        size--;
    }

    @Override
    public void output() {
        System.out.println(array.toString());
    }
}
