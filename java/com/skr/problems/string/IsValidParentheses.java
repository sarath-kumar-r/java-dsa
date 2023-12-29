package com.skr.problems.string;

import java.util.ArrayDeque;

public class IsValidParentheses {

    public boolean isValid(String s) {

        ArrayDeque<Character> queue = new ArrayDeque<>();

        for(char c: s.toCharArray()) {
            if(c == '{' || c == '(' || c == '[') {
                queue.push(c);
            } else {
                if(queue.isEmpty()) {
                    return false;
                }
                char top = queue.peekFirst();
                if(top == '{' && c == '}' ||
                        top == '[' && c == ']' ||
                        top == '(' && c == ')') {
                    queue.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}
