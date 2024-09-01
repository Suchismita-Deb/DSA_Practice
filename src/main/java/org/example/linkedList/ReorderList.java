package org.example.linkedList;

// https://leetcode.com/problems/reorder-list/description/

public class ReorderList {
    class Solution {
        public void reorderList(ListNode head) {
            // 1 2 3 4 5 6
            // 1 6 2 5 3 4
            // Divide the list in two halves - 1 2 3 and 4 5 6 and reverse the second part.
            // 1 2 3
            // 6 5 4
            // List taking one element from first and one from second array.
            // 1 6 2 5 3 4
            // Finding the middle of the list using slow and fast.
            // Reverse the second part of the list.
            // Make the connection.
            ListNode fast = head;
            ListNode slow = head;
            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
            // Reverse the list from slow to the end.
            ListNode second = slow.next; // The starting of the second half.
            slow.next = null; // Splitting into two different list.
            ListNode prev = null;
            while(second!=null){
                ListNode temp = second.next;
                second.next = prev;
                prev = second;
                second = temp;
            }
            // Merge the two list.
            // second will be null and the prev will be on the first of the list.
            second = prev;
            ListNode first = head;
            // Continue till one of the pointer becomes null.
            while(first!=null && second !=null){
                ListNode temp = first.next;
                first.next = second;
                first = temp;
                ListNode temp1 = second.next;
                second.next = temp;
                second = temp1;
            }
        }
    }
}
