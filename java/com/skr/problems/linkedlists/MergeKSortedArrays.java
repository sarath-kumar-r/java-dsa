package com.skr.problems.linkedlists;


import com.skr.problems.pojo.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;



public class MergeKSortedArrays {
    public ListNode mergeKLists(ListNode[] lists) {


        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the head of each list into the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
    }
}
