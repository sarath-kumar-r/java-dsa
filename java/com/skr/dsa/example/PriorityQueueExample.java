package com.skr.dsa.example;

import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Insert elements with priorities
        priorityQueue.offer(5); // Insert 5
        priorityQueue.offer(1); // Insert 1
        priorityQueue.offer(3); // Insert 3
        priorityQueue.offer(2); // Insert 2

        // Peek at the highest-priority element (min heap, so it's the smallest)
        System.out.println("Highest Priority Element: " + priorityQueue.peek()); // Output: 1

        // Poll and remove the highest-priority element
        int highestPriority = priorityQueue.poll();
        System.out.println("Removed Highest Priority Element: " + highestPriority); // Output: 1

        // Peek again to see the new highest-priority element
        System.out.println("New Highest Priority Element: " + priorityQueue.peek()); // Output: 2

    }
}
