/* Problem
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/* 2nd round, still two pointers, seems the same with last attempt, but runtime improve from 320ms to 1ms
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //alg: maintain two pointers p1 and p2;
        //p1 traverse the list one by one;
        //p2 moves only when a new unique element is found by p1; then link that elment the node p2 points to.
        
        //corner cases:
        if (head == null || head.next == null){
            return head;
        }
        
        //general cases:
        ListNode p1 = head;
        ListNode p2 = head;
        while(p1.next!=null) {
            if(p1.val != p1.next.val) {
                p2.next = p1.next;
                p2 = p2.next;// p2 only moves when a new unique node is linked.
            }
            p1 = p1.next; // p1 keeps moving no matter what.
        }
        p2.next = null;
        // after p1 looping through all nodes, nodes behind p2 shouldn't included in the result, and thus set p2 to be the last node.
        
        return head;
    }
}
 
/*1st round, 2 pointers*/ 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode rtn = head;
        ListNode fast = head.next;
        
        while(fast!=null)
        {
            if(head.val!=fast.val)
            {
                head.next=fast;
                head=head.next;
            }
            fast=fast.next;
        }
        head.next=null;
        return rtn;
        
    }
}