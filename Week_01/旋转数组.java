package com.carol.practice.geekbang;

public class RotateArrays {
    /**
     * [1,2,3,4,5,6,7] k = 3
     * index = (0 + 3) % 7 = 3 : 1移动到4,4单独保存，变成[1,2,3,1,5,6,7] temp = 4
     * index = (3 + 3) % 7 = 6 : 4移动到7,7单独保存，变成[1,2,3,1,5,6,4] temp = 7
     * index = (6 + 3) % 7 = 2 : 7移动到3,3单独保存，变成[1,2,7,1,5,6,4] temp = 3
     * index = (2 + 3) % 7 = 5 : 3移动到6，6单独保存，变成[1,2,7,1,5,3,4] temp = 6
     * index = (5 + 3) % 7 = 1 : 6移动到2，2单独保存，变成[1,6,7,1,5,3,4] temp = 2
     * index = (1 + 3) % 7 = 4 : 2移动到5，5单独保存，变成[1,6,7,1,2,3,4] temp = 5
     * index = (4 + 3) % 7 = 0 : 5移动到1，变成[5,6,7,1,2,3,4]
     *内层循环结束条件index == i
     *
     * [-1,-100,3,99] 和 k = 2
     * index = (0 + 2) % 4 = 2 : -1移动到3, 3单独保存， 变成[-1,-100,-1,99] temp = 3
     * index = (2 + 2) % 4 = 0 ： 3移动到-1， 变成[3,-100,-1,99]
     * 内层循环结束条件index == i
     * index = (1 + 2) % 4 = 3 ： -100移动到99， 99单独保存，变成 变成[3,-100,-1,-100] temp = 99
     * index = (3 + 2) % 4 = 1 ： 99移动到-100， -100单独保存，变成 变成[3,99,-1,-100] temp = -100
     *内层循环结束条件index == i
     */

    public static void rotate1(int[] nums, int k){
        int len = nums.length;
        if (len < 2) {
            return;
        }

        k = k % len;
        if (k < 1) {
            return;
        }

        int srcIndex = 0;
        int count = 0;
        for (; srcIndex < len; srcIndex++) {
            int srcTemp = nums[srcIndex];
            int dstIndex = srcIndex;
            do{
               dstIndex = (dstIndex + k) % len;
               int dstTemp = nums[dstIndex];
               nums[dstIndex] = srcTemp;
               srcTemp = dstTemp;
               count++;
            }while (dstIndex != srcIndex);

            if(count == len) {
                return;
            }
        }
    }

    /***
     *数组翻转
     * 思路：移动k位，就是将后k个元素放在数组最前k个位置，剩下的n-k个元素一次往后移动k位
     * 由于要使用原地算法
     * 1、整个数组对调，头变尾，尾变头
     * 2、将前面k个元素对调，恢复到原来的顺序
     * 3、将后面n-k个元素对调，恢复到原来的顺序
     *
     *
     */
    public static void rotate2(int[] nums, int k){
        int len = nums.length;
        if (len < 2) {
            return;
        }

        k = k % len;
        if (k < 1) {
            return;
        }
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private static void reverse(int[] arrays, int start, int end) {
        while(start < end) {
            arrays[start] = arrays[start] ^ arrays[end];
            arrays[end] = arrays[start] ^ arrays[end];
            arrays[start] = arrays[start] ^ arrays[end];
            start++;
            end--;
        }
    }
}
