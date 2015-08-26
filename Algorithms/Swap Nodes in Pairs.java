/* Problem: Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        //corner cases;
        if(head==null||head.next==null) return head;
        if(head.next.next==null){
            ListNode rst = head.next;
            head.next=null;
            rst.next=head;
            return rst;
        }
        
        //using 2 pointers to iterate, keeping track of the node before and after the pair.
        //ListNode fast = head.next.next;
        //head.next.next = head;
        //head.next = fast;
        ListNode p0 = null;
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode p3 = null;
        ListNode rst = head.next; //keep the new head as return value.
        while(p1!=null && p1.next!=null) {
            p2=p1.next;
            p3=p1.next.next;
            
            p2.next=p1;
            p1.next=p3;
            if(p0!=null){
                p0.next=p2;
            }
            p0=p1;
            p1=p3;
        }
        return rst;
    }
}