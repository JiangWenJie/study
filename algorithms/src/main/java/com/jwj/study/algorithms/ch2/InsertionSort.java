package com.jwj.study.algorithms.ch2;

import java.util.Arrays;

/**
 * @Author: jwj
 * @Date: 2020/8/20 14:04
 * @Description: 插入排序——循环不变式
 */
public class InsertionSort {

    public void insertionSort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            int key = source[i];
            int j = i - 1;
            while (j >= 0 && source[j] > key) {
                source[j+1]=source[j];
                source[j]=key;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] source = {31, 41, 59, 26, 41, 58};
        new InsertionSort().insertionSort(source);
        System.out.println(Arrays.toString(source));
    }


}
