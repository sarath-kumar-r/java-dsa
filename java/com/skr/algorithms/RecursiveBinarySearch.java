package com.skr.algorithms;

public class RecursiveBinarySearch {

    // Recursive method to perform a binary search
    public static int binarySearch(int[] array, int left, int right, int target) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (array[mid] == target) {
                return mid; // target found
            }

            // If target is greater than mid, then it can only be in the right subarray
            if (array[mid] < target) {
                return binarySearch(array, mid + 1, right, target);
            }

            // Else the target can only be in the left subarray
            return binarySearch(array, left, mid - 1, target);
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int result = binarySearch(array, 0, array.length - 1, target);

        if (result == -1) {
            System.out.println("Element not present in the array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
