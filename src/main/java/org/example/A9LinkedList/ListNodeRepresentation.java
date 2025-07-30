package org.example.A9LinkedList;

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

public class ListNodeRepresentation {
    public static void main(String[] args) {
        ListNode l = new ListNode(5);
        l.next = new ListNode(6);
        l.next.next = new ListNode(7);
        l.next.next.next = new ListNode(8);
        ListNode head = l;
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
