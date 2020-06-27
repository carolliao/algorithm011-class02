package com.carol.practice.geekbang;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class MergeOrderArrays {
    //暴力解法：单独开辟一个数组，然后同时变量两个数组中元素的大小，将较小值一次放入
    //新开辟的数组中。
    //完成之后，重新拷贝到nums1中
    //时间复杂度：O(m + n) 空间复杂度：O(m + n)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int k = 0;
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }

            k++;
        }

        if (i < m) {
            for (; i < m; i++) {
                temp[k++] = nums1[i];
            }
        } else if (j < n) {
            for (; j < n; j++) {
                temp[k++] = nums2[j];
            }
        }

        System.arraycopy(temp, 0, nums1, 0, m + n);
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        //先将nums1中的数组存放在一个新的数组中
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int k = 0;
        int i = 0;
        int j = 0;
        while(i < m && j < n){
            if(temp[i] < nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }

            k++;
        }

        if (i < m) {
            for (; i < m; i++) {
                nums1[k++] = temp[i];
            }
        } else if (j < n) {
            for (; j < n; j++) {
                nums1[k++] = nums2[j];
            }
        }
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n){
        //先将nums2中的元素添加到nums1中
        System.arraycopy(nums2, 0, nums1, m , n);
        //重新排序
        Arrays.sort(nums1);
    }
}
