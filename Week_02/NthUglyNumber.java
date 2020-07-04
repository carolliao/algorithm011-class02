package com.carol.practice.geekbang.week2;

/**
 * 获取丑数.求按从小到大的顺序的第 n 个丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）
 *示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        return alogrithm1(n);
    }

    /**
     * 暴力法
     * @param n
     * @return
     */
    public static int alogrithm1(int n){
        if(n < 2 || n > 1690){
            return 1;
        }

        int number = 1;
        int count = 1;
        int lastUglyNumber = 1;
        while(count < n){
            number++;
            int value = number;
            boolean ok = false;
            while(!ok){
                if(value % 2 == 0){
                    value /= 2;
                }else if(value % 3 == 0){
                    value /= 3;
                }else if(value % 5 == 0){
                    value /= 5;
                }else{
                    ok = true;
                }
            }

            if(value == 1){
                lastUglyNumber = number;
                count++;
            }
        }

        return lastUglyNumber;
    }

    /**
     * 动态规划
     * 核心思想：因为数组dp中是丑数，那么dp[a] * 2, dp[b] * 3, dp[c] * 5也一定是丑数
     * 所以下一个要找的丑数，肯定是min(dp[a] * 2, dp[b] * 3, dp[c] * 5)中最小的那一个
     * @param n
     * @return
     */
    public static int alogrithm2(int n) {
        if (n < 2 || n > 1690) {
            return 1;
        }
        int a= 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++){
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }

        return dp[n - 1];
    }
}
