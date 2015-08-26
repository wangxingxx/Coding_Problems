/* Problem: Reverse Linked List
 * Reverse a singly linked list.
 */


/*1st round using extra stack memory*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        
        Stack<Integer> vals = new Stack<Integer>();
        ListNode curNode = head;
        while(curNode!=null){
            vals.push(curNode.val);
            curNode = curNode.next;
        }
        ListNode reverse = new ListNode(vals.pop());
        ListNode rst = reverse;
        while(!vals.isEmpty()){
            reverse.next=new ListNode(vals.pop());
            reverse = reverse.next;
        }
        return rst;
        
    }
}

/*2nd round, using loop no extra memory*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return head;
        
        ListNode fast = head.next;
        ListNode slow = head;
        head.next=null;
        while(fast!=null && slow != null){
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        return slow;
        
    }
    
}