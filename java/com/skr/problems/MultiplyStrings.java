package com.skr.problems;

public class MultiplyStrings {

    public static void main(String[] args) {

        String num1 = "12";
        String num2 = "6";

        System.out.println(multiply(num1, num2));

    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }


        int m = num1.length();
        int n = num2.length();


        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : result) {
            if (sb.length() > 0 || val != 0) {
                sb.append(val);
            }
        }
        return sb.toString();
    }

}
