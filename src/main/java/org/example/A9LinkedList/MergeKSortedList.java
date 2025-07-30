package org.example.A9LinkedList;

// https://leetcode.com/problems/merge-k-sorted-lists/description/

public class MergeKSortedList {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            int size = lists.length;
            int interval = 1;
            while (interval < size) {
                for (int i = 0; i < size - interval; i += 2 * interval) {
                    lists[i] = merge2Sorted(lists[i], lists[i + interval]);
                }
                interval *= 2;
            }
            return size > 0 ? lists[0] : null;
        }

        ListNode merge2Sorted(ListNode l1, ListNode l2) {
            ListNode root = new ListNode();
            ListNode prev = root;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            if (l1 != null) {
                prev.next = l1;
            } else if (l2 != null) {
                prev.next = l2;
            }
            return root.next;
        }
    }
}
