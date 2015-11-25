/* Problem: Add Two Numbers
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

/*1st round, one-pass, keep the new head, be careful with the last bit*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //corner case:
        if (l1 == null || l2 == null) return null;
        //ask interviewer if null input should be expected all will be excluded in contract.
        
        //general case:
        int carry;
        ListNode dummyHead = new ListNode(-1);
        ListNode head;
        int sum_0 = l1.val + l2.val;
        if (sum_0 >= 10) {
            head = new ListNode(sum_0 % 10);
            carry = 1;
        } else {
            head = new ListNode(sum_0);
            carry = 0;
        }
        dummyHead.next = head;
        l1 = l1.next;
        l2 = l2.next;
        
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            ListNode curr;
            if (sum >= 10) {
                curr = new ListNode(sum % 10);
                carry = 1;
            } else {
                curr = new ListNode(sum);
                carry = 0;
            }
            head.next = curr;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        if (l1 != null) {
            while (l1 != null) {
                int sum = l1.val + carry;
                ListNode curr;
                if (sum >= 10) {
                    curr = new ListNode(sum % 10);
                    carry = 1;
                } else {
                    curr = new ListNode(sum);
                    carry = 0;
                }
                head.next = curr;
                head = head.next;
                l1 = l1.next;
            }
        }
        
        if (l2 != null) {
            while (l2 != null) {
                int sum = l2.val + carry;
                ListNode curr;
                if (sum >= 10) {
                    curr = new ListNode(sum % 10);
                    carry = 1;
                } else {
                    curr = new ListNode(sum);
                    carry = 0;
                }
                head.next = curr;
                head = head.next;
                l2 = l2.next;
            }
        } 
        
        if (carry == 1) {
            head.next = new ListNode(1);
            head = head.next;
        }
        
        return dummyHead.next;
        
    }
}