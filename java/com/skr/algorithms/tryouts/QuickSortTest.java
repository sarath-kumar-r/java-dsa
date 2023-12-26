package com.skr.algorithms.tryouts;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {

        int[] arr = new int[]{6, 3, 4, 1, 5, 9, 7, 2, 8, 0, 10, 15, 13, 12, 14, 1, 11, -1};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {

        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, 0, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {

            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = pivot;
        arr[end] = temp;
        return i + 1;
    }
}
