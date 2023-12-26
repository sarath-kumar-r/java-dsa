package com.skr.problems.array.medium;

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
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
