package org.example.linkedList;

// https://leetcode.com/problems/reverse-linked-list/description/

public class ReverseLinkedList {
    class Iterative {
        public ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            ListNode currNext = null;
            // Null 1->2->3
            // Null 1<-2<-3
            while(curr!=null){
                currNext = curr.next;
                curr.next = prev;
                prev = curr;
                curr = currNext;
            }
            return prev;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head==null)return null;
            return rev(head,null);
        }
        ListNode rev(ListNode curr, ListNode prev){
            if(curr==null) return prev;
            ListNode temp = curr.next;
            curr.next=prev;
            return rev(temp,curr);
        }
    }
}
