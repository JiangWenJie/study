package com.jwj.study.algorithms.ch2;

import java.util.Arrays;

/**
 * @Author: jwj
 * @Date: 2020/8/24 16:27
 * @Description: 归并排序——分治法
 */
public class MergeSort {

    public int[] mergeSort(int[] source) {
        if (source.length==1){
            return source;
        }
        int[] target=new int[source.length];
        int[] left=new int[source.length/2];
        int[] right=new int[source.length-source.length/2];
        for (int i = 0; i < source.length/2; i++) {
            left[i]=source[i];
        }
        int j=0;
        for (int i = source.length/2; i < source.length; i++) {
            right[j]=source[i];
            j++;
        }
        mergeSort(left);
        mergeSort(right);
        int l=0;
        int r=0;
        for (int i = 0; i < target.length; i++) {
            if (r<right.length&&l<left.length&&left[l]<right[r]){
                target[i]=left[l];
                l++;
            }else if (r<right.length&&l<left.length&&  left[l]>=right[r]){
                target[i]=right[r];
                r++;
            }


        }
        return target;
    }

    public static void main(String[] args) {
        int[] source = {31, 41, 59, 26};
        int[] target=new MergeSort().mergeSort(source);
        System.out.println(Arrays.toString(target));
    }
}
