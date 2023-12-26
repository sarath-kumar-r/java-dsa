package com.skr.problems.linkedlists;

import com.skr.problems.pojo.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        // Add the two list heads to the queue
        queue.add(l1);
        queue.add(l2);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!queue.isEmpty()) {
            ListNode smallestNode = queue.poll();
            tail.next = smallestNode;
            tail = tail.next;

            if (smallestNode.next != null) {
                queue.add(smallestNode.next);
            }
        }

        return dummy.next;
    }
}
