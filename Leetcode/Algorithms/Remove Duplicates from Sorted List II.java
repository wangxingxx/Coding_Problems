/** Problem: Remove Duplicates from Sorted List II
  * Given a sorted linked list, delete all nodes that have duplicate numbers, 
  * leaving only distinct numbers from the original list.
  * For example,
  * Given 1->2->3->3->4->4->5, return 1->2->5.
  * Given 1->1->1->2->3, return 2->3.
  */

/*1st round, two pionters, in place, O(n)*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //alg:
        //create a dummyHead pointing to head to solve the problem that the head not distinct.
        //and maitain two pointers
        //cur loops throught the list one by one to find new node 
        //(not neccessary distinct only cur.val != cur.next.val)
        //pre links to all new nodes found by cur, but only moves when a new distinct node is found. 
        
        //corner case:
        //null/empty, single node;
        if (head == null || head.next == null) {
            return head;
        }
        
        //general case:
        ListNode dummyHead=new ListNode(-999);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode cur=head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                //loop to find next new node (not the same with its following node), not knowing if it's distinct or not.
                cur=cur.next;
            }
            if(pre.next==cur){
            //if there's no duplicates between last distinct node to this new node, then this new node is also distinct
                pre=pre.next;// pre only moves when a new distinct node is found.
            }
            else{//else this new node is actually a dupe of nodes before it.
                pre.next=cur.next;//pre links to this node but does not move.
            }
            cur=cur.next;//cur keeps moving no matter what.
        }
        return dummyHead.next;

    }
}