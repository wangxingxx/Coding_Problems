/* Problem: Merge Sorted Array
 * Given two sorted integer arrays nums1 and nums2, 
 * merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

/*1st round, in-place, one-pass, the key is to start from the end*/ 
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //corner case
        //empty nums2
        if(n == 0) return;
        
        
        //general case
        while (n > 0){
            if (m == 0 || nums1[m - 1] < nums2[n - 1]) {
                nums1[m + n - 1] = nums2[--n];
            }else {
                nums1[m + n - 1] = nums1[--m];
            }
        }
    }
}