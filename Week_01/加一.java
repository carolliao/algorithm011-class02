package com.carol.practice.geekbang;

public class PluseOne {
    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        if(i < 0) {
            return digits;
        }
        for (; i >= 0; i--) {
            int sum = digits[i] + 1;
            if (sum > 9) {
                digits[i] = sum % 10;
            }else{
                digits[i] = sum;
                break;
            }
        }

        if (i < 0) {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            System.arraycopy(digits, 0, temp, 1, digits.length);
            return temp;
        } else {
            return digits;
        }
    }
}
