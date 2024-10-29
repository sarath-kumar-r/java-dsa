package com.skr.problems.array.medium;

import java.util.stream.IntStream;

/*238. Product of Array Except Self
Solved
Medium
Topics
Companies
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)*/

public class ProductsExpectSelf {

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        // Initialize left and right product arrays
        int[] leftProducts = new int[length];
        int[] rightProducts = new int[length];

        // Initialize the output array
        int[] output = new int[length];

        // Calculate left products
        leftProducts[0] = 1;
        for (int i = 1; i < length; i++) {
            leftProducts[i] = nums[i - 1] * leftProducts[i - 1];
        }

        // Calculate right products
        rightProducts[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightProducts[i] = nums[i + 1] * rightProducts[i + 1];
        }

        // Calculate the product of elements except self
        for (int i = 0; i < length; i++) {
            output[i] = leftProducts[i] * rightProducts[i];
        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; // {1, 1, 2, 6}- left
        // {24, 12, 4, 1}
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
