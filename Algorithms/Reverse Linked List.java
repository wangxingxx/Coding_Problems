/* Problem: Reverse Linked List
 * Reverse a singly linked list.
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