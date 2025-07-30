package org.example.A9LinkedList;

public class DeleteMiddleNodeOfList {
    class FindingMiddle {
        public ListNode deleteMiddle(ListNode head) {
            int size = 0;
            if (head == null)
                return null;
            if (head.next == null)
                return null; // single node.
            ListNode temp = head;
            while (temp != null) {
                // Need to go till the last node.
                size++;
                temp = temp.next;
            }
            System.out.println(size);
            int mid = size / 2;
            int i = 0;
            temp = head;
            while (temp != null) {
                i++;
                if (i == mid) {
                    // It should be till the mid.
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }

            return head;
        }
    }
    class TwoPointerSlowFast {
        public ListNode deleteMiddle(ListNode head) {
            if(head.next==null) return null;
            // Fast and slow pointer.
            // fast move by two steps and slow moves by one step. When fast is at the end
            // then the slow will point to the middle.
            ListNode fast = head;
            ListNode slow = head;
            ListNode prev = null; // prev to point before the slow so that we can remove the middle and make the
            // next of the prev to the prev.next.next.
            while(fast!=null && fast.next!=null){ // terminal condition when it will stop.
                fast = fast.next.next;
                prev = slow;
                slow = slow.next;
            }
            prev.next = prev.next.next;
            return head;
        }
    }
}
