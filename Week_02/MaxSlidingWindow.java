package com.carol.practice.geekbang.week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 求滑动窗口在数组中移动时每次窗口中的最大值
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return alogrithm(nums, k);
    }

    /**
     * 暴力法
     * @param nums
     * @param k
     * @return
     */
    public static int[] alogrithm(int[] nums, int k){
        if(k == 0 || k == 1 || nums.length < k){
            return  nums;
        }
        int winHead = 0;
        int winTail = k - 1;
        int[] ans = new int[nums.length - k + 1];
        for(int i = 0; i < ans.length; i++){
            int max = 0;
            for(int j = winHead; j <= winTail;j++){
                if(nums[j] > max){
                    max = nums[j];
                }
            }
            ans[i] = max;
            winHead++;
            winTail++;
        }

        return ans;
    }

    /**
     * 利用大根堆来计算
     * @param nums
     * @param k
     * @return
     */
    public static int[] alogrithm1(int[] nums, int k){
        if(k == 0 || k == 1 || nums.length < k){
            return  nums;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return t1 - integer;
            }
        });
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxHeap.size() >= k){
                maxHeap.remove(nums[i - k]);
            }
            maxHeap.add(nums[i]);
            if(i >= k - 1){
                ans[index++] = maxHeap.peek();
            }
        }

        return ans;
    }

    /**
     * 双向队列
     * @param nums
     * @param k
     * @return
     */
    public static int[] alogrithm2(int[] nums, int k){
        int n = nums.length;
        if(n * k == 0) return new int[0];
        if(k == 1) return nums;
        ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
        int max_idx = 0;
        for(int i = 0; i < k; i++){
            cleanQueue(deq, nums, i, k);
            deq.addLast(i);
            if(nums[i] > nums[max_idx]) max_idx = i;
        }

        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];
        for(int i = k; i < n; i++){
            cleanQueue(deq, nums, i, k);
            deq.addLast(i);
            output[i - k + 1]  = nums[deq.getFirst()];
        }

        return output;
    }


    private static void cleanQueue(Deque<Integer> deque, int[] nums, int i, int k){
        if(!deque.isEmpty() && deque.getFirst() == i - k){
            deque.removeFirst();
        }

        while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]);
    }
}
