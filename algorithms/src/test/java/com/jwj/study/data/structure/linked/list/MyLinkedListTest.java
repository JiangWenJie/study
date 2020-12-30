package com.jwj.study.data.structure.linked.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {
    private MyLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList=new MyLinkedList();
    }

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            linkedList.insert(i,i);
        }
        linkedList.output();
        System.out.println(linkedList.remove(0));
        System.out.println(linkedList.remove(5));
        System.out.println(linkedList.remove(7));
        linkedList.output();
    }
}
