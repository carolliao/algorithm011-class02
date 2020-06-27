package com.carol.practice.geekbang;

public class RemoveDuplicatesInArrays {

    /**
     * 暴力解法：相邻元素i和i+1进行比较，如果相等就把i+1后面的元素向前移动
     * @param arrays
     * @return
     */
    public static int solution1(int[] arrays) {
        int length = arrays.length;
        if(length < 2) {
            return length;
        }
        for (int i = 0; i < length - 1; i++) {
            if(arrays[i] == arrays[i + 1]) {
                for (int j = i + 1; j < length - 1; j++){
                    arrays[j] = arrays[j + 1];
                }
                length--;
                i--;
            }
        }

        return length;
    }

    /**
     * 元素缓存法：因为数组是有序的，所以当相邻元素i和i+1不相等时，可以将i+1的元素存放在
     * 元素索引为j的位置，这个j记录了不相等的元素位置
     * @param arrays
     * @return
     */
    public static int solution2(int[] arrays) {
        int length = arrays.length;
        if(length < 2) {
            return length;
        }

        int j = 0;
        for (int i = 1; i < length; i++) {
            if(arrays[j] != arrays[i]) {
                arrays[++j] = arrays[i];
            }
        }
        j++;

        return j;
    }
}
