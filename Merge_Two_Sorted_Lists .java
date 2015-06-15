

/** Merge two sorted linked lists and return it as a new list. 
 *  The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        
        //store the head of list for return
        ListNode rst = new ListNode(-1);
        //actual pointer to build up the list
        ListNode act = rst;
        
        while(l1!=null&&l2!=null)
        {
            if (l1.val >=l2.val) 
            {act.next=l2;
            l2=l2.next;
            }
            else
            {act.next=l1;
            l1=l1.next;
            }
            act=act.next;
            act.next=null;
        }
        
        
        if (l1 == null && l2!=null) act.next=l2;
        if (l1 != null && l2==null) act.next=l1;
        
        return rst.next;
        
    }
}