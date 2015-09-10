/* Problem: 3Sum
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is: (-1, 0, 1) (-1, -1, 2)
 */



/*1st round, naive brute force, does the job but too slow*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 1st round, brute force
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[k]);
                        rst.add(item);
                    }
                }
            }
        }
        
        int m = rst.size();
        for (int i = 0; i < m-1; i++) {
            Collections.sort(rst.get(i));
            for (int j = i + 1; j < m; j++) {
                Collections.sort(rst.get(j));
                if (rst.get(i).equals(rst.get(j))) {
                    rst.get(j).clear();
                }
            }
        }
        for (int i = 0; i < rst.size(); i++) {
            if (rst.get(i).size() == 0)
                rst.remove(i);
        }
        
        return rst;
    }
}