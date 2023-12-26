package com.skr.algorithms;

public class ArrayRotation {

    public static int[] rotateArray(int[] arr, int k) {
        int n = arr.length;

        // Handle the case where k is greater than the length of the array
        k = k % n;

        int[] rotated = new int[n];

        // Rotate the array to the right by k positions
        for (int i = 0; i < n; i++) {
            int newIndex = (i + n - k) % n;
            rotated[newIndex] = arr[i];
        }

        return rotated;
    }


    public static void rotateInPlace(int[] arr, int k) {
        int n = arr.length;

        // Handle the case where k is greater than the length of the array
        k = k % n;

        // Reverse the entire array
        reverse(arr, 0, n - 1);

        // Reverse the first part of the array (0 to n-k-1)
        reverse(arr, 0, n - k - 1);

        // Reverse the second part of the array (n-k to n-1)
        reverse(arr, n - k, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        int k = 2; // Rotate by 2 positions

        rotateInPlace(myArray, k);

        // Print the rotated array
        for (int num : myArray) {
            System.out.print(num + " ");
        }
    }
}
