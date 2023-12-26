package com.skr.problems;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int n = digits.length;

        for(int i = n - 1; i >= 0; --i) {

            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newArr = new int[digits.length + 1];
        newArr[0] = 1;
        return newArr;
    }
}
