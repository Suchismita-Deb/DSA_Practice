package org.example.A9LinkedList.Practice;

public class A1DetectCycle {
    public static void main(String[] args) {
        // https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1
        // 1 -> 3 -> 2 -> 4 -> 5 -> 3 (5 pointing to 3)
        // 1 -> 3 -> 2 -> 4 -> 5 -> 6 -> 3 (6 pointing to 3)
        // slow==fast - there is a cycle and when there is a cycle then move the slow from head when equal then there is a cycle.


    }
    public static ListNode findFirstNode(ListNode head) {
        // code here
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                slow = head;
                while(slow!=fast){
                    slow = slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    ListNode() {}
}