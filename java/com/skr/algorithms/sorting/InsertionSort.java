package com.skr.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array: " + Arrays.toString(array));

        insertionSort(array);

        System.out.println("\nSorted Array: " + Arrays.toString(array));
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
