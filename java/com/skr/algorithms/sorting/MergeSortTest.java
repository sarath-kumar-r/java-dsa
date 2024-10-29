package com.skr.algorithms.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSortTest {


    void sort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {12, 11, 13, 5, 6, 7};
//
//        MergeSortTest ob = new MergeSortTest();
////        ob.sort(arr, 0, arr.length - 1);
//        ob.sort(arr, 0, arr.length - 1);
//        System.out.println("Sorted array:");
//        System.out.println(Arrays.toString(arr));


        long[] arr = {1, 3, 5, 2, 4, 6};
        int n = arr.length;
        long result = Solution.getInversions(arr, n);
        System.out.println("Number of inversions: " + result); // Should print 3

    }

    public class Solution {
        public static long getInversions(long[] arr, int n) {
            return mergeAndCount(arr, 0, n - 1);

        }

        private static int mergeAndCount(long[] arr, int start, int end) {
            int count = 0;
            if (start < end) {
                int mid = start + (end - start) / 2;

                // Recursively count inversions in the left and right subarrays
                count += mergeAndCount(arr, start, mid);
                count += mergeAndCount(arr, mid + 1, end);

                // Merge the two subarrays and count inversions during merging
                count += merge(arr, start, mid, end);
            }
            return count;
        }

        private static int merge(long[] arr, int start, int mid, int end) {
            int n1 = mid - start + 1;
            int n2 = end - mid;

            long[] left = Arrays.copyOfRange(arr, start, mid + 1);
            long[] right = Arrays.copyOfRange(arr, mid + 1, end + 1);

            int i = 0, j = 0;
            int k = start;
            int count = 0;

            // Merge the two arrays while counting inversions
            while (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                    // Inversion count: all remaining elements in left[] are greater than right[j]
                    count += (n1 - i);
                }
                k++;
            }

            // Copy the remaining elements of left[]
            while (i < n1) {
                arr[k] = left[i];
                i++;
                k++;
            }

            // Copy the remaining elements of right[]
            while (j < n2) {
                arr[k] = right[j];
                j++;
                k++;
            }

            return count;
        }
    }
}

