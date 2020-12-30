package com.jwj.study.data.structure;

import com.jwj.study.data.structure.array.MyArray;
import org.junit.Before;
import org.junit.Test;

public class MyArrayTest {
    private MyArray myArray;

    @Before
    public void setUp() throws Exception {
        myArray = new MyArray(5);
        System.out.println("初始化 " + myArray);
    }

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            myArray.insert(i, i);
        }
        System.out.println("插入 " + myArray);
    }

    @Test
    public void update() {
        myArray.update(99, 8);
        System.out.println("更新 " + myArray);
    }

    @Test
    public void delete() {
        myArray.delete(8);
        System.out.println("删除 " + myArray);
    }

    @Test
    public void select() {
        int element = myArray.select(8);
        System.out.println("查询 " + element);
    }

    @Test
    public void testArray() {
        insert();
        update();
        delete();
        select();
    }
}
