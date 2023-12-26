package com.skr.dsa.implementation;

import java.util.ArrayList;
import java.util.List;

public class MinPriorityQueue<T extends Comparable<T>> {

    private final List<T> heap;

    public MinPriorityQueue() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public void insert(T item) {
        heap.add(item);
        int currentIndex = heap.size() - 1;
        bubbleUp(currentIndex);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }

        T min = heap.get(0);
        int lastIndex = heap.size() - 1;
        T lastItem = heap.remove(lastIndex);

        if (!isEmpty()) {
            heap.set(0, lastItem);
            bubbleDown(0);
        }

        return min;
    }

    private void bubbleUp(int currentIndex) {
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (heap.get(currentIndex).compareTo(heap.get(parentIndex)) < 0) {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int currentIndex) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;
        int smallestIndex = currentIndex;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != currentIndex) {
            swap(currentIndex, smallestIndex);
            bubbleDown(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void main(String[] args) {
        MinPriorityQueue<Integer> pq = new MinPriorityQueue<>();
        pq.insert(4);
        pq.insert(1);
        pq.insert(3);
        pq.insert(2);

        while (!pq.isEmpty()) {
            System.out.print(pq.extractMin() + " ");
        }
        // Output: 1 2 3 4
    }
}
