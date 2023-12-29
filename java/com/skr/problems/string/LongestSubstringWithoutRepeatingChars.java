package com.skr.problems.string;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        int startIndex = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int endIndex = 0; endIndex < s.length(); endIndex++) {

            System.out.println(startIndex + " end " + endIndex + " max length " + maxLength);
            System.out.println(charIndexMap);

            char currentChar = s.charAt(endIndex); //a
            if (charIndexMap.containsKey(currentChar)) {
                // If the current character is already in the map, update the start index
                startIndex = Math.max(startIndex, charIndexMap.get(currentChar) + 1);
            }

            charIndexMap.put(currentChar, endIndex); /// a,0
            // Calculate the current substring length
            int currentLength = endIndex - startIndex + 1;
            // Update the maximum length
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }



    public static void main(String[] args) {

        String input = "abcabcdbb";
        int result = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);

    }
}
