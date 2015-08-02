/**
 * Problem:
 * Given a linked list, determine if it has a cycle in it.
 * Can you solve it without using extra space?
 */
 
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        /* use two pointers fast and slow to iterate nodes in the list
         * fast move two nodes forward in each loop, slow move one node each loop.
         * if there's no cycle in the list, then the two pointers will never meet before fast reach the last node;
         * then if they meet at some point, then it means there's a cyple in the linked list
        */
        while (fast !=null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}