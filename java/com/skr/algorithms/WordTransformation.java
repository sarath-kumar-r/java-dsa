package com.skr.algorithms;

import java.util.*;

public class WordTransformation {

    public static int ladderLength(String startWord, String targetWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(targetWord)) {
            return 0; // Target word is not in the word list
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);
        int level = 1; // Starting level

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                if (currentWord.equals(targetWord)) {
                    return level;
                }

                // Generate all possible transformations
                char[] wordArray = currentWord.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;

                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Mark as visited
                        }
                    }

                    wordArray[j] = originalChar; // Restore original character
                }
            }

            level++;
        }

        return 0; // No transformation found
    }

    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int result = ladderLength(startWord, targetWord, wordList);
        System.out.println("Minimum transformations: " + result); // Expected output: 5
    }
}
