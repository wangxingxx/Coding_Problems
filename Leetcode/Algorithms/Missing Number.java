/* Problem: Missing Number  
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int[] helper = new int[n+1];
        for(int i=0;i<n;i++){
            helper[nums[i]]=1;
        }
        int rst = -1;
        for(int j=0;j<n+1;j++){
            if (helper[j]==0) {
                rst = j;
                break;
            }
            
        }
        return rst;
    }
}