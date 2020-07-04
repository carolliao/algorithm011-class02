package com.carol.practice.geekbang.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中组最小的K个元素
 */
public class MinKElementsInArrays {
    /**
     * 暴力解法
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] mins = new int[k];
        for (int j = 0; j < k; j++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    index = i;
                }
            }
            mins[j] = min;
            arr[index] = Integer.MAX_VALUE;
        }

        return mins;
    }

    /**
     * 利用小根堆来获取
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        for(int i = 0; i < arr.length; i++){
            minHeap.add(arr[i]);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = minHeap.remove();
        }

        return ans;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });
        for(int i = 0; i < k; i++){
            minHeap.add(arr[i]);
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = minHeap.remove();
        }

        return ans;
    }

}
