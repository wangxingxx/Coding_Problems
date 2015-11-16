/* Problem: Partition List
 * Given a linked list and a value x, 
 * partition it such that all nodes less than x 
 * come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 */


/*2nd round, one-pass, constant extra space, two pointers, keep moving smaller node to the front*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        //corner case:
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode lg=dummy;
        ListNode sm=dummy;
        while(lg != null && lg.next != null){
            if(lg.next.val>=x) { // if the next node is larger than target, skip
                lg=lg.next;
            }
            else{ // if the next node smaller than target, move and insert this node to the place between sm and sm.next.
                if(lg==sm){  //unless they are actually pointing the same node.
                    sm=sm.next;
                    lg=lg.next;
                }
                else{
                    ListNode tmp=lg.next;
                    lg.next=tmp.next;//remove this node from between lg and tmp.next; 
                    tmp.next=sm.next;
                    sm.next=tmp;//insert this node inbetween sm and sm.next;
                    sm=tmp; //move sm.
                }
            }
        }
        return dummy.next;
    }
}
/*1st round, one-pass, two extra List with intotal O(n) space*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        //naive alg, use two extra Lists
        
        //corner case:
        if(head == null || head.next == null) {
            return head;
        }
        
        //general case;
        ListNode sm = new ListNode(-1);
        ListNode smcur = sm;
        ListNode lg = new ListNode(100);//values don't matter, just to help to understand the variables.
        ListNode lgcur = lg;
        while(head != null) {
            if (head.val >= x) {
                lgcur.next = head;
                lgcur = lgcur.next;
            }else {
                smcur.next = head;
                smcur = smcur.next;
            }
            head = head.next;
        }
        
        smcur.next = lg.next;
        lgcur.next = null;
        
        return sm.next;
    }
}