package com.skr.problems.array.easy;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("The Container With Most Water - " + calculateContainerWithMostWater(arr));
    }

    // we are using two pointer here
    public static int calculateContainerWithMostWater(int[] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int distance = right - left;
            int altitude = Math.min(arr[right], arr[left]);
            int area = distance * altitude;
            maxArea = Math.max(area, maxArea);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
