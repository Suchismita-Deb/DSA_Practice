package org.example.A9LinkedList;

public class RemoveNthNodeFromEndOfList {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int size = 1;
            ListNode temp = head;
            while (temp.next != null) {
                size++;
                temp = temp.next;
            }
            // The size of the list.
            int index = size - n;
            temp = head;
            if (index == 0) return head.next;

            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return head;
        }
    }

    class TwoPointerFastAndSlow {
        /*
         For eg. let the list be 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9, and n = 4.

    1. 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
       ^slow               ^fast
       |<--gap of n nodes-->|

     => Now traverse till fast reaches end

     2. 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
                            ^slow               ^fast
                            |<--gap of n nodes-->|

    'slow' is at (n+1)th node from end.
    So just delete nth node from end by assigning slow -> next as slow -> next -> next (which would remove nth node from end of list).
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            ListNode slow = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;// iterate to the nth node.
            }
            if (fast == null) return head.next; // if fast is null then we have to remove the head.
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
