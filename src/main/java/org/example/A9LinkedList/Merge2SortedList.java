package org.example.A9LinkedList;

// https://leetcode.com/problems/merge-two-sorted-lists/description/

public class Merge2SortedList {
    class Iterative {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode();
            // Need to make another pointer to add the value and return the root as it will point in the beginning.
            ListNode prev = root;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    prev.next = list2;
                    list2 = list2.next;
                } else {
                    prev.next = list1;
                    list1 = list1.next;
                }
                prev = prev.next;
            }
            if (list1 != null) {
                prev.next = list1;
            } else if (list2 != null) {
                prev.next = list2;
            }
            return root.next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            return merge(list1, list2);
        }

        ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;

            if (l2 == null) return l1;

            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }
    }
}
