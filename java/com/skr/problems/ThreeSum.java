package com.skr.problems;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class ThreeSum {

    public static void main(String[] args) {

        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Possible Three Sums are:");
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || nums[i - 1] != nums[i]) {

                int k = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {

                    int sum = nums[left] + nums[right];
                    if (sum == k) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
