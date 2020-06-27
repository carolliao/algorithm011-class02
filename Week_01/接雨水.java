package com.carol.practice.geekbang;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 接雨水：计算柱形图凹槽能够存储的雨水
 */
public class ConnectedRainwater {
    /**
     * 栈方法：
     * 1、如果当前元素高度比栈顶元素高度小就直接入栈
     * 2、如果当前元素高度比栈顶元素高度大，则栈顶元素出栈，计算当前元素与新的栈顶元素的距离，即凹槽的宽度
     * 凹槽的宽度=(当前元素的索引值 - 新的栈顶元素的索引值 - 1)，
     * 凹槽的高度=min(当前元素的高度，新的栈顶元素的高度) - 弹出时的栈顶元素的高度
     * 本次凹槽的面积(即水的面积) = 凹槽的宽度 * 凹槽的高度
     * 然后使用当前元素与新的栈顶元素继续比较，重复2
     *
     * @param heights
     * @return
     */
    public int trap(int[] heights){
        int len = heights.length;
        if(len < 3) {
            return 0;
        }
        //stack存储的是heights数组的索引值
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int area = 0;
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peekLast()]) {
                //弹出栈顶元素
                int h = heights[stack.pollLast()];
                if(stack.isEmpty()) {
                    stack.addLast(i);
                    break;
                }
                //根据新的栈顶元素计算宽高
                int width = (i - stack.peekLast()) - 1;
                int height = Math.min(heights[i], heights[stack.peekLast()]) - h;
                area += (width * height);
            }

            stack.addLast(i);
        }

        return area;
    }

}
