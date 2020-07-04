package com.carol.practice.geekbang.week2;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        return alogrithm(nums,k);
    }

    /**
     * 利用HashMap来计数
     * @param nums
     * @param k
     * @return
     */
    public static int[] alogrithm(int[] nums, int k) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //利用大根堆获取计数最大值.注意这里是根据计数值的大小来存放对应的元素值的
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return map.get(t1) - map.get(integer);
            }
        });

        for (Integer key:
             map.keySet()) {
            maxHeap.add(key);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = maxHeap.remove();
        }

        return ans;
    }
}
