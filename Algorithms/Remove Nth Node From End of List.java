/* Problem: Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */


/*1st round, in-place, on-pass*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //alg: maintain two pointers p1, p2.
        //p2 is n node faster than p1.
        //they moves at same pace, one at a time.
        //when p2 reaches the end, p1 skips the next node, but connects the node after next node.
        //return head.
        
        //corner cases:
        //null, empty, single node, remove the head.
        if (head == null || n == 0) {
            return head;
        }
        
        if (head.next == null && n > 0) {
            return null;
        }
        
        
        ListNode p1 = head;
        ListNode p2 = head;
        while (n > 0) {
            p2 = p2.next;
            n--;
        }
        
        if (p2 == null) {//corner case: the node to be removed is the head.
            head = head.next;
            return head;
        }
        
        //general cases:
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        
        p1.next = p1.next.next;
        
        return head;
    }
}