/* Problem: Remove Element
 * Given an array and a value, 
 * remove all instances of that value in place and return the new length.
 * The order of elements can be changed. 
 * It doesn't matter what you leave beyond the new length.
 */


/*1st round, in-place, O(n) time*/
public class Solution {
    public int removeElement(int[] nums, int val) {
        //alg:
        //two pointers:
        //front scan from the beginning untill meets back; if target if found, swap value with back.
        //back scan from the end untill meets front; 
        
        int n = nums.length;
        //corner case:
        //empty, single element.
        if (n == 0) {
            return 0;
        } 
        if (n == 1) {
            if (nums[0] == val)
                return 0;
            return 1;
        }
        
        //general case: 
        int front = 0;
        int back = n - 1;
        while (front < back){
            if (nums[front] == val) {
                while (back >= front) {
                    if (back == front) {// if until back moves to front, there's no qualified element to swap, then the scan should stop and return the length of [0,...front-1]
                        return front;
                    }                    
                    if (nums[back] != val) {
                        nums[front] = nums[back];
                        nums[back] = val;
                        back--;
                        break;
                    }
                    back --;
                }

            }
            front ++;
        }
        if (nums[front] != val ) {
            return front + 1;
        } else return front;
    }
}