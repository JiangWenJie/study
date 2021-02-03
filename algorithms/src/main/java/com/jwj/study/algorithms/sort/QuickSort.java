package com.jwj.study.algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序的基本实现
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class QuickSort {
    public void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    private int partition(int[] array, int startIndex, int endIndex) {
        int mark = startIndex;
        int pivot = array[startIndex];
        for (int i = startIndex+1; i <= endIndex; i++) {
            if (array[i] < pivot) {
                mark++;
                int tmp = array[mark];
                array[mark] = array[i];
                array[i] = tmp;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
