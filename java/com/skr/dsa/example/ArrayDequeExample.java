package com.skr.dsa.example;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeExample {

    public static void main(String[] args) {
        // Create an ArrayDeque
        ArrayDeque<String> deque = new ArrayDeque<>();

        // Adding elements using offerFirst and offerLast
        deque.offerFirst("C");
        deque.offerLast("D");
        deque.offerFirst("B");
        deque.offerLast("E");
        deque.offerFirst("A");

        // Accessing elements at the front and back
        System.out.println("Front of the deque: " + deque.peekFirst()); // Output: A
        System.out.println("Back of the deque: " + deque.peekLast()); // Output: E

        // Removing elements from the front and back
        System.out.println("Removed from the front: " + deque.pollFirst()); // Output: A
        System.out.println("Removed from the back: " + deque.pollLast()); // Output: E

        // Checking if the deque contains an element
        System.out.println("Contains 'B': " + deque.contains("B")); // Output: true

        // Size of the deque
        System.out.println("Deque size: " + deque.size()); // Output: 3

        // Iterating through the deque
        System.out.println("Deque elements:");
        for (String element : deque) {
            System.out.println(element);
        }

        // Using an iterator
        Iterator<String> iterator = deque.iterator();
        System.out.println("Deque elements using iterator:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Converting the deque to an array
        String[] array = deque.toArray(new String[0]);
        System.out.println("Array from deque:");
        for (String element : array) {
            System.out.println(element);
        }
    }
}
