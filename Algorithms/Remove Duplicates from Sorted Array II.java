/** Problem: Remove Duplicates from Sorted Array II
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * Your function should return length = 5, 
 * with the first five elements of nums being 1, 1, 2, 2 and 3. 
 * It doesn't matter what you leave beyond the new length.
 */
 
/*1st round, O(1) extra space, O(n) time*/
public class Solution {
    public int removeDuplicates(int[] nums) {
        //alg: maintain two pointers:
        // p1 travers the array one-by-one, 
        // p2 moves when a new unique element is found by p1 or duplicate counter is < 2, and copy that element to [p2]. when a new element is found, duplicate counter is set back to 1;
        
        int n = nums.length;
        //corner cases
        //TODO: null, empty, length = 1
        if (n < 2) {
            return n;
        }
        //general cases
        int p2 = 1;
        int dpct = 1;
        for(int p1 = 1; p1 < n; p1++) {
            if (nums[p1] == nums[p1-1] && dpct < 2) {
                nums[p2++] = nums[p1];
                dpct++;
                continue;
            }
            if (nums[p1] != nums[p1-1]) {
                nums[p2++] = nums[p1];
                dpct=1;
            }
        }
        
        return p2; 
        //p2 points to the place to write a unique element, but not yet. So the last element of unique array is p2 - 1, so the length of that array would be p2 - 1 + 1 = p2, instead of p2 + 1;
    }
}