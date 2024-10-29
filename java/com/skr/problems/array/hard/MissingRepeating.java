package com.skr.problems.array.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRepeating {

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int size = A.size();
        long sum = (long) size * ( size + 1) / 2; // n(n+1)/2
        long sumSquare = (long) size * (size + 1) * (2L * size + 1) / 6; // n(n+1)(2n+1)/6
        long sumA = 0;
        long sumAsqure = 0;
        for(Integer ele: A) {
            sumA += ele;
            sumAsqure += (long) Math.pow(ele, 2);
        }
        long sumDiff = sumA - sum;//x-y
        long squareDiff = sumAsqure - sumSquare; //(x+y)(x-y) = squareDiff
        long xy = squareDiff / sumDiff; // x +y  = squareDiff/(x-y) i.e. squareDiff/sumDiff

        // solve x+y and x-y = 2x = (x+y) + sumDiff
        long x = (xy + sumDiff) / 2;
        long y = x - sumDiff;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) x);
        ans.add((int) y);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(repeatedNumber(Arrays.asList(1, 2, 3, 3, 6, 5, 7)));
    }

}
