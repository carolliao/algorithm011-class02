package com.carol.practice.geekbang;

/**
 * 将数组中的零值元素移动到数组的尾部，同时保证非零元素的相对顺序不变
 * 条件：不能单独开辟数组空间只能在原数组上操作
 */
public class MoveZero {

    /**
     * 解题思路：设置两个索引值，其中一个用于遍历数组，另个记录当元素是非零元素的位置
     * 并将非零元素覆盖这个数组的新位置
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0; //记录0的个数
        for (; i < nums.length; i++) {
            if (nums[i] == 0) {
                k++;
            } else {
                nums[j++] = nums[i];
            }
        }

        for ( int m = 0; m < k; m++) {
            nums[m + j] = 0;
        }
    }
}
