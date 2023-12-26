package com.skr.problems.linkedlists;

import com.skr.problems.pojo.ListNode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
        }

        if (carry > 0) {
            result.next = new ListNode(carry);
        }

        return dummy.next;
    }

}
