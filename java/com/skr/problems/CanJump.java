package com.skr.problems;

public class CanJump {

    public static void main(String[] args) {

//        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;

        for (int i = 0; i < n; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}
