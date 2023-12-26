package com.skr.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 5, 100, 0};

        System.out.println("Original Array: " + Arrays.toString(array));

        bucketSort(array);

        System.out.println("\nSorted Array: " + Arrays.toString(array));
    }

    public static void bucketSort(int[] arr) {

        int maxVal = Arrays.stream(arr).max().getAsInt();
        int minVal = Arrays.stream(arr).min().getAsInt();

        int bucketCount = (maxVal - minVal) / arr.length + 1;
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);

        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // Place elements into buckets
        for (int num : arr) {
            int bucketIndex = (num - minVal) / arr.length;
            buckets.get(bucketIndex).add(num);
        }

        // Sort each bucket (in this example, we use Collections.sort)
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Merge the sorted buckets back into the original array
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
}

