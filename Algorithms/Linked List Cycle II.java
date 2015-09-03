/* Problem: Linked List Cycle II
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
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
    public ListNode detectCycle(ListNode head) {
        //Corner cases:
        if (head == null || head.next == null || head.next.next == null) return null;
        
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                ListNode rst = head;
                while (true) {
                    if (rst == fast) {
                        return rst;
                    } else {
                        rst = rst.next;
                        fast = fast.next;
                    }
                }
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        
        return null;
        
    }
}