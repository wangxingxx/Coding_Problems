
/* Problem: Rotate List
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */

/*1st round, two-passed so O(n), in-place*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //alg:
        //first-pass to find out the length of list n, and keep the end using a pointer end.
        //also create a dummyHead to point to the current head for later to return.
        //maintain a pointer p, points to the node right before rotate node. 
        //then connects previous dummyHead.next = p.next; p.next = null, end.next = head;
        
        //corner case:
        //null, single node list, k is larger or equal to list length.
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        ListNode p = head;
        int n = 1;
        while (p.next != null) {// O(n)
            p = p.next;
            n++;
        }
        ListNode end = p; //keep the end node.
        
        if (k >= n) {
            k = k % n;
        }
        
        if (k == 0) {
            return head;
        }
        // these two corner cases are more about the understanding of the problem, and should be a good question to check with interviewer about allowed k (what if k is larger than n) before starting to write solutions. 
        
        //general case:
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        p = head;
        int d = n - k;
        while (d > 1) {// create a window from dummyNode to right before rotate node.
            p = p.next;
            d--;
        }
        
        dummyHead.next = p.next;
        p.next = null;
        end.next = head;
        
        
        return dummyHead.next;
        
    }
}