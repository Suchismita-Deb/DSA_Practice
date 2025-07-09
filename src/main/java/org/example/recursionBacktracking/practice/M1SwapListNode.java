package org.example.recursionBacktracking.practice;

// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    ListNode() {}
}
// Input: head = [1,2,3,5]
// Output: [2,1,5,3]
public class M1SwapListNode {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next); // return second.
        // Recursion function will return the second value and the first will point to the the second value.
        second.next = first;

        return second;
    }
}
