package com.skr.problems.linkedlists;

import com.skr.problems.pojo.ListNode;

public class RemoveNthNode {

    public static void main(String[] args) {
        testReverseKGroup_ExactKGroups();
        testRemoveNthFromEnd();
        testReverseList();
        testMergeTwoLists();
        testAddTwoNumbers();
        testHasCycle();
        testGetIntersectionNode();
    }

    public static void testReverseKGroup_ExactKGroups() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);
        System.out.println("Result for k = 2 (Exact K-Groups): " + listToString(result));
    }

    public static void testRemoveNthFromEnd() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        int n = 2;
        ListNode result = solution.removeNthFromEnd(head, n);
        System.out.println("Result for removeNthFromEnd (n = 2): " + listToString(result));
    }

    public static void testReverseList() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result = solution.reverseList(head);
        System.out.println("Result for reverseList: " + listToString(result));
    }

    public static void testMergeTwoLists() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode list1 = buildList(new int[]{1, 3, 5});
        ListNode list2 = buildList(new int[]{2, 4, 6});
        ListNode result = solution.mergeTwoLists(list1, list2);
        System.out.println("Result for mergeTwoLists: " + listToString(result));
    }

    public static void testAddTwoNumbers() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode l1 = buildList(new int[]{2, 4, 3});
        ListNode l2 = buildList(new int[]{5, 6, 4});
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println("Result for addTwoNumbers: " + listToString(result));
    }

    public static void testHasCycle() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        head.next.next.next.next = head.next; // Creates a cycle at node 2
        boolean result = solution.hasCycle(head);
        System.out.println("Result for hasCycle (should be true): " + result);
    }

    public static void testGetIntersectionNode() {
        RemoveNthNode solution = new RemoveNthNode();
        ListNode headA = buildList(new int[]{4, 1});
        ListNode headB = buildList(new int[]{5, 6, 1});
        ListNode intersection = buildList(new int[]{8, 4, 5});

        // Append the intersection to both lists
        appendList(headA, intersection);
        appendList(headB, intersection);

        ListNode result = solution.getIntersectionNode(headA, headB);
        System.out.println("Result for getIntersectionNode (should be node with value 8): " + (result != null ? result.val : "null"));
    }

    public static void appendList(ListNode head, ListNode toAppend) {
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = toAppend;
    }

    // Helper method to build a linked list from an array
    private static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to convert a linked list to a string for easy printing
    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast in front so that the gap between slow and fast becomes n
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        // Move fast to the end, maintaining the gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the desired node
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next;  // Save the next node
            current.next = prev;               // Reverse the current node's pointer
            prev = current;                    // Move prev and current one step forward
            current = nextTemp;
        }
        return prev;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val) + carry;
            int val = sum % 10;
            carry = sum / 10;
            tail.next = new ListNode(val);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode balance = l1 != null ? l1 : l2;
        while (balance != null) {
            int sum = balance.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            tail.next = new ListNode(val);
            tail = tail.next;
            balance = balance.next;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists; if one pointer reaches the end, switch it to the head of the other list.
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        // Either they meet at the intersection node or at null (no intersection)
        return pointerA;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to help with pointer manipulation
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, end = head;

        // Count total nodes
        int count = 0;
        while (end != null) {
            count++;
            end = end.next;
        }

        // Traverse and reverse every k-group
        end = head;
        while (count >= k) {
            ListNode start = prev.next;
            ListNode next = end;

            // Move end pointer k steps ahead
            for (int i = 0; i < k; i++) {
                end = end.next;
            }

            // Reverse the k nodes
            prev.next = reverse(start, end);
            start.next = end;

            // Move prev and reduce count by k
            prev = start;
            count -= k;
        }

        return dummy.next;
    }

    // Helper method to reverse the list from start to end (not including end)
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        while (start != end) {
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }
        return prev;
    }
}
