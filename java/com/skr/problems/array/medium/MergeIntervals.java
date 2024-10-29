package com.skr.problems.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.stream(merge(arr)).toList());
    }
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] interval: intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < interval[0]) {
                ans.add(interval);
            } else {
                ans.getLast()[1] = Math.max(ans.getLast()[1], interval[1]);
            }
        }
        return ans.toArray(new int[][]{});
    }
}
