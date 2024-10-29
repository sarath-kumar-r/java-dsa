package com.skr.problems.array.medium;

/*2. Subarray Sum Equals K (#560)
Difficulty: Medium
Problem: Find the number of continuous subarrays whose sum equals to a given number k.*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsK {


    public static void main(String[] args) {

        System.out.println(subarraySum(new int[]{1,2,3, 0}, 2));
    }
    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        int prefixSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num: nums) {
            prefixSum += num;
            count += map.getOrDefault(prefixSum - k, 0);
            map.merge(prefixSum, 1, Integer::sum);
        }
        return count;
    }
}
