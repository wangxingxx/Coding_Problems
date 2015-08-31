/* Problem: Find Peak Element
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */


/*1st round, O(n) running time*/
public class Solution {
    public int findPeakElement(int[] nums) {
        //corner cases:
        if(nums==null || nums.length==0) return -1;
        int n = nums.length;
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return nums.length-1;
        
        for(int i=1;i<n-1;i++){
            if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]) 
            return i;
        }
        return 0;
        
    }
}

/*2nd round, recursively, O(lg n) running time*/
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        return helper(nums,0,n-1);
    }
    public int helper (int[] nums, int start, int end){
        if(start>=end) return end;
        if(end-start==1 && nums[start]>nums[end]) return start;
        if(end-start==1 && nums[end]>nums[start]) return end;
        
        int mid = (start+end)/2;
        if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
        else if(nums[mid]<nums[mid-1]) return helper(nums, start, mid);
        else return helper(nums, mid, end);
    }
}