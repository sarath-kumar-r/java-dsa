package com.skr.fw;

public class SquareRootWithPrecision {

    public static double squareRoot(int N, int D) {
        double low = 0, high = N;
        double mid = 0.0;

        // Binary search for the integer part and the initial decimal places
        while (high - low > Math.pow(10, -D)) {
            mid = (low + high) / 2;
            if (mid * mid <= N) {
                low = mid;
            } else {
                high = mid;
            }
        }

        // Rounding the result to D decimal places
        return Math.round(mid * Math.pow(10, D)) / Math.pow(10, D);
    }

    public static void main(String[] args) {
        int N = 10;
        int D = 3;
        System.out.println("Square root of " + N + " with precision " + D + " is: " + squareRoot(N, D));
    }
}
