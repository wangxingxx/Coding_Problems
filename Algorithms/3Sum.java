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

/*3rd round, O(N^2), still too slow*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 3rd round, improve the time complexity of finding qualifying combinations from NlgN to N.
        // Total running time O(N^2), still too slow
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        // Corner cases:
        if (nums == null || nums.length < 3) return rst;
        
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
        //for (int i = 0; i < n-2; i++) {
            int target = 0 - nums[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end && start > i && end > i) {
                if (nums[start] + nums[end] == target) {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[start]);
                    item.add(nums[end]);
                    rst.add(item);
                    start++;
                    end--;
                }else if (nums[start] + nums[end] < target) {
                    start++;
                }else end--;
            }
            //for (int j = i + 1; j < n-1; j++) {
                //int rest = 0 - nums[i] - nums[j];
                //int restID = bs(rest, nums, j+1, n-1);
                //if (restID != -1) {
                //    List<Integer> item = new ArrayList<Integer>();
                //    item.add(nums[i]);
                //    item.add(nums[j]);
                //    item.add(nums[restID]);
                //    rst.add(item);
                //}
                
            //}
        }
        
        int m = rst.size();
        for (int i = 0; i < m-1; i++) {
        //for (int i = 0; i < rst.size()-1; i++) {
            Collections.sort(rst.get(i));
            for (int j = i + 1; j < m; j++) {
            //for (int j = i + 1; j < rst.size(); j++) {
                Collections.sort(rst.get(j));
                if (rst.get(i).equals(rst.get(j))) {
                    rst.get(j).clear();
                }
            }
        }
        List<List<Integer>> rstNew = new ArrayList<List<Integer>>();
        for (int i = 0; i < rst.size(); i++) {
            if (rst.get(i).size() != 0)
                rstNew.add(rst.get(i));
        }
        
        return rstNew;
    }
}

/*2nd round, sort nums first, and then using binary search to find third number for each combination of two numbers
 *does the job, but still too slow, O(N^2 * lgN)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 2nd round, sort + binary search
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                int rest = 0 - nums[i] - nums[j];
                int restID = bs(rest, nums, j+1, n-1);
                if (restID != -1) {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(nums[restID]);
                    rst.add(item);
                }
                
            }
        }
        
        int m = rst.size();
        //for (int i = 0; i < m-1; i++) {
        for (int i = 0; i < rst.size()-1; i++) {
            Collections.sort(rst.get(i));
            //for (int j = i + 1; j < m; j++) {
            for (int j = i + 1; j < rst.size(); j++) {
                Collections.sort(rst.get(j));
                if (rst.get(i).equals(rst.get(j))) {
                    rst.remove(j);
                }
            }
        }
        //for (int i = 0; i < rst.size(); i++) {
        //    if (rst.get(i).size() == 0)
        //        rst.remove(i);
        //}
        
        return rst;
    }
    
    private int bs(int target, int[] nums, int start, int end) {
        if (start >= end) {
            if (nums[end] == target) return end;
            else return -1;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return bs(target, nums, mid+1, end);
        else return bs(target, nums, start, mid-1);
    }
}

/*1st round, naive brute force, O(N^3),does the job but too slow*/
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

