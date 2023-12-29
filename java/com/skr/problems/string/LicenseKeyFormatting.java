package com.skr.problems.string;

public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {

        String newS = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder(newS);
        int i = sb.length() - k;
        while (i > 0) {
            sb.insert(i, '-');
            i -= k;
        }
        return sb.toString();
    }
}
