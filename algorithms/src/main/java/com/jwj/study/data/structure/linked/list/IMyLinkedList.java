package com.jwj.study.data.structure.linked.list;

/**
 * @author jwj
 * @date 2020/12/30 11:27
 * @description 单向链表接口
 * @since 1.0
 */
public interface IMyLinkedList {
    void insert(int index,int data);
    int remove(int index);
    int get(int index);
    void output();
}
