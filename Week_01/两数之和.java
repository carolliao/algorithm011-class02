package com.carol.practice.geekbang;

/**
 * 给定一个数组和目标和的值，返回元素相加等于目标值的元素的索引值
 * 审题：目标值只能是数组中两个元素之和，并且元素不能重复使用即不能在
 * 求和公式中反复出现
 */
public class Summation {

    /**
     * 暴力解法：遍历数组中每个元素，然后使用目标值减去元素值得到一个差值，再使用这个差值去遍历
     * 数组中其他元素的值看是否有元素值跟差值相同的
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        boolean ok = false;
        for (; i < nums.length; i++) {
            int diff = target - nums[i];
            j = i + 1;
            for (; j < nums.length; j++) {
                if(diff == nums[j]) {
                    ok = true;
                    break;
                }
            }

            if(ok) {
                break;
            }
        }
        if(ok) {
            return new int[]{i, j};
        }

        return null;
    }
}
