package com.jwj.study.data.structure.linked.list;

import javax.xml.crypto.Data;

/**
 * @author jwj
 * @date 2020/12/30 11:14
 * @description 单向链表实现
 * @since 1.0
 */
public class MyLinkedList implements IMyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void insert(int index, int data) {
        Node currentNode = new Node(data);
        if (0 == size) {
            head = currentNode;
            tail = currentNode;
        } else if (0 == index) {
            currentNode.next = head;
            head = currentNode;
        } else if (size == index) {
            tail.next = currentNode;
            tail = currentNode;
        } else {
            Node temp = getNode(index - 1);
            currentNode.next = temp.next;
            temp.next = currentNode;
        }
        size++;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        int result=0;
        if (0==index){
            head=head.next;
            result=head.data;
        }else if (size-1==index){
            Node prev=getNode(index-1);
            result=prev.next.data;
            prev.next=null;
            tail=prev;
        }else {
            Node prev=getNode(index-1);
            result=prev.next.data;
            prev.next=prev.next.next;
        }
        size--;
        return result;
    }

    @Override
    public int get(int index) {
        return getNode(index).data;
    }

    @Override
    public void output() {
        String output = "size:" + size + "  node: ";
        Node node = head;
        while (null != node) {
            output += ("" + node.data + " -> ");
            node = node.next;
        }
        if (output.endsWith(" -> ")) {
            System.out.println(output.substring(0, output.length() - 4));
        } else {
            System.out.println(output);
        }
    }

    private Node getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }


    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
