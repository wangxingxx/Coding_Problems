/* Problem: Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * assume that there is only one duplicate number, find the duplicate one.
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */


/*2nd round, binary search to locate the range where duplicates are in*/
public class Solution {
    public int findDuplicate(int[] nums) {
        // Corner case: because n>= 1, so nums.length = n+1 >= 2;
        if (nums == null || nums.length == 1)
            return -1;

        // General case:
        // binary search:
        int n = nums.length-1;
        int low = 1;
        int upp = n;
        while(low < upp){
            int count=0;
            int mid = (low+upp)/2;
            for (int i = 0; i < n+1; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                upp = mid;
            } else {
                low = mid + 1;
            }
            
        }
        return low;
    }
}

/*1st round, brute force, O(n^2)*/
public class Solution {
    public int findDuplicate(int[] nums) {
        //Corner case: because n>= 1, so nums.length = n+1 >= 2;
        if (nums == null || nums.length == 1) return -1;
        
        //General case:
        //brute force:
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        
        return -1;
    }
}