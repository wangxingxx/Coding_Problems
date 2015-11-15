/* Problem: 4Sum
 * Given an array S of n integers, are there elements a, b, c, and d in S 
 * such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 *   (-1,  0, 0, 1)
 *   (-2, -1, 1, 2)
 *   (-2,  0, 0, 2)
 */

/*1st round, based on 3Sum, four pointers, O(n^3)*/ 
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        //corner case
        if (nums.length < 4) {
            return rst;
        }
        
        
        //general case
        Arrays.sort(nums); 
        int n = nums.length;
        
        //List<Integer> quadruplets;
        
        for(int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n - 2; j++){
                if (j > i + 1 && nums[j] == nums[j-1]) continue;
                int rest = target - nums[i] - nums[j];
                int lo = j + 1;
                int hi = n - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == rest) {
                        //quadruplets = Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]);
                        rst.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                        //this is faster than the above
                        while (lo < hi && nums[lo+1] == nums[lo]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi-1] == nums[hi]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    }else if (nums[lo] + nums[hi] > rest) {
                        hi--;
                    }else {
                        lo++;
                    }
                }
            }
        }
        return rst;
    }
}