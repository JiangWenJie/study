package com.jwj.study.algorithms.sort;

import java.util.Arrays;

/**
 * 冒泡排序的实现
 * <p>来自《漫画算法:小灰的算法之旅》-4.2</p>
 * <p>提供了三种实现</p>
 * <p>实现1 基本冒泡排序</p>
 * <p>实现2 加入了有序标记位，降低了循环次数</p>
 * <p>实现3 在2的基础上增加了有序边界探测，降低了每次单次循环需要遍历的个数</p>
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class BubbleSort {
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
            System.out.println("第" + (i + 1) + "轮:" + Arrays.toString(array));
        }
    }

    /**
     * 冒泡排序的优化1
     * 增加了标记位，如果有序则无需继续排序
     *
     * @param array 需要进行排序的数组
     */
    public void sort2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    isSorted = false;
                }
            }
            System.out.println("第" + (i + 1) + "轮:" + Arrays.toString(array) + " 标记:" + isSorted);
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序的优化2
     * 增加了标记位，如果有序则无需继续排序
     * 增加了边界值探测，有序的数据不许再冒泡
     *
     * @param array 需要进行排序的数组
     */
    public void sort3(int[] array) {
        int sortBorder = array.length - 1;
        int lastExchangeIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            System.out.println("第" + (i + 1) + "轮:" + Arrays.toString(array) + " 标记:" + isSorted + " 边界:" + sortBorder);
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序的基本实现
     *
     * @param array 需要进行排序的数组
     */
    public void sort4(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            for (int j = array.length - i - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 2, 1, 5, 6, 7, 8};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort4(array);
        System.out.println(Arrays.toString(array));
    }
}
