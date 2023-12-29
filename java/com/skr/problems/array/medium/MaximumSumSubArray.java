package com.skr.problems.array.medium;

public class MaximumSumSubArray {

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 6, -1, 2, 1};
        int k = 3;
        maximumSumSubArray(nums, k);
    }

    public static void maximumSumSubArray(int[] nums, int k) {

        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        maxSum = currentSum;
        for (int i = k; i < nums.length; i++) {

            currentSum += nums[i];
            currentSum -= nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
