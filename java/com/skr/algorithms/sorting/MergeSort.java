package com.skr.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    // Main function that sorts arr[l..r] using merge()
    void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // Merges two subarrays of arr[]
    void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
//        System.arraycopy(arr, l, L, 0, n1);
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        MergeSort ob = new MergeSort();
//        ob.sort(arr, 0, arr.length - 1);
        ob.quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

    }


    private void quickSort(int[] arr, int s, int e) {

        if (s < e) {
            int pivotIndex = partition(arr, s, e);
            quickSort(arr, s, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, e);
        }
    }


    private int partition(int[] arr, int s, int e) {

        int pivot = arr[e];
        int i = s - 1;

        for (int j = s; j < e; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pivotIndex = i + 1;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[e];
        arr[e] = temp;
        return pivotIndex;
    }


    private void merge(int[] arr, int start, int end) {

        if( start < end) {
            int mid = start + (end - start) / 2;
            merge(arr, start, mid);
            merge(arr, mid + 1, end);

            sortAndMerge(arr, start, mid, end);
        }

    }

    private void sortAndMerge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] leftArr = Arrays.copyOfRange(arr, start, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, end +1);

        int i = 0, j = 0, k = start;

        while(i < n1 && j < n2) {
            if(leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }


    }

}
