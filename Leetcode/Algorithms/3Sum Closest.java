/* Problem: 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

/*1st round, O(n^2), three pointers*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //alg: fix the first elment of the triplet.
        //use two pointers lo and hi to loop through the rest;
        //update optimal sum when a smaller different of |target - sum| is found.
        
        int n = nums.length;
        int rst, diff;
        //corner case:
        //<= 3 elments in nums
        if (n <= 3) {
            rst = 0;
            for (int elm : nums) {
                rst += elm;
            }
            return rst;
        }
        
        //general case:
        Arrays.sort(nums);
        rst = nums[0] + nums[1] + nums[n-1];
        diff = Math.abs(target - rst);
        for (int i = 0; i < n - 2; i++){
            int lo = i + 1, hi = n - 1;
            int rest = target -nums[i];
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (Math.abs(target - nums[i] - sum) < diff ) {
                    rst = nums[i] + sum;
                    diff = Math.abs(target - rst);
                }
                
                if (sum < rest) {
                    lo++;
                }else if (sum > rest) {
                    hi--;
                }else {
                    return nums[i] + sum;
                }
            }
        }
        
        return rst;
        
    }
}