package com.skr.problems.stack;

import java.util.Stack;

public class InsertAtBottomOfStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push some elements onto the stack (for demonstration)
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Element to be inserted at the bottom
        int elementToInsert = 4;

        // Insert the element at the bottom of the stack
        insertAtBottom(stack, elementToInsert);

        // Print the stack to verify the insertion
        System.out.println("Stack after inserting at the bottom: " + stack);
    }

    // Function to insert an element at the bottom of a stack
    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        // Pop all elements and store them in the function call stack
        int temp = stack.pop();
        insertAtBottom(stack, element);

        // Push the temporarily stored elements back onto the stack
        stack.push(temp);
    }
}

