package com.skr.problems.array.medium;

public class MaximumSubarray {

    public static int maxSubArray1(int[] nums) {

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {

        int maxSum = nums[0];
        int currentSum = 0;

        for (int i: nums) {
            currentSum += i;
            maxSum = Math.max(currentSum, maxSum);
            if (currentSum < 0) currentSum = 0;
        }

        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    public static int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int maxLeftSum = maxSubArray(nums, left, mid);
        int maxRightSum = maxSubArray(nums, mid + 1, right);
        int maxCrossSum = maxCrossingSum(nums, left, mid, right);

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxCrossSum);
    }

    public static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftMaxSum = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid; i >= left; i--) {
            leftSum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, leftSum);
        }

        int rightMaxSum = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            rightSum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, rightSum);
        }

        return leftMaxSum + rightMaxSum;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-2, -1, -3, -4};
        int result = maxSubArray2(nums);
        System.out.println("Maximum Subarray Sum: " + result); // Output: 6 (the subarray [4, -1, 2, 1] has the maximum sum)
    }
}

