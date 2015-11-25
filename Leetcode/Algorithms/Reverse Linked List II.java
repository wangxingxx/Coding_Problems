/* Problem: Reverse Linked List II
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */

/*1st round, in-place, one-pass*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //alg:
        //four pointers
        //p1 and p2 set the slide window, that p2 is (m-n) faster than p1.
        //right before p1 reaches the m-th node:
        //1. let p3 points to m-th node.
        //2. p1, (m-1)th node, points to p2.next, n-th node;
        //3. p1 = p3, keep the m-th node for later to link to (n+1)-th node;
        //   p2 = p2.next.next, set the end point, (n+1)-th node.
        //4. let p4 = p3.next, then use p4 and p3 to reverse the link until p4 = p2.
        //5. p1.next = p2, connects m-th node to (n+1)-th node.
        
        //corner cases:
        //null, single node list, m=n
        if (head == null || m == n || head.next == null) {
            return head;
        }
        
        //general cases:
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;
        int d = n-m;
        while (d > 0) {//let p2 (n-m) faster than p1, create a sliding window.
            p2 = p2.next;
            d--;
        }
        
        while (m > 1) {//move the sliding window to stop at (m-1)-th node.
            p1 = p1.next;
            p2 = p2.next;
            m--;
        }
        
        ListNode p3 = p1.next; //keeps the m-th node.
        p1.next = p2.next;
        p1 = p3; // p1 now points to m-th node
        p2 = p2.next.next; // p2 now points to (n+1)th node.
        
        ListNode p4 = p3.next;
        while (p4 != p2) {
            ListNode tmp = p4.next;
            p4.next = p3; // reverse the link
            p3 = p4; 
            p4 = tmp; //both p3 and p4 move a step forward
        }
        
        p1.next = p2; //now points m-th node to (n+1)-th node.
        
        return dummyHead.next;
    }
}