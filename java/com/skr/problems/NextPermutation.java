package com.skr.problems;

import java.util.Arrays;

public class NextPermutation {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 3, 2};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {

        if(nums.length < 2 ) {
            return;
        }

        int n = nums.length;
        int i = n - 2; // second last index

        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if(i >= 0) {
            int j = n - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private static void reverse(int[] nums, int start, int end) {

        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
