package com.jwj.study.data.structure;

import java.util.Arrays;

/**
 * @author jwj
 * @date 2020/12/25 09:42
 * @description 数组的实现
 * @since 1.0
 */
public class MyArray implements IMyArray {

    private int[] array;
    private int size;

    public MyArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    @Override
    public void insert(int element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组大小");
        }
        if (size >= array.length) {
            resize();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public int update(int element, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        array[index] = element;
        return index;
    }

    @Override
    public int delete(int index) {
        //判断访问下标是否超出范围
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        int element = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public int select(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围！");
        }
        return array[index];
    }
}
