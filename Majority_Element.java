

/** Given an array of size n, find the majority element. 
 *  The majority element is the element that appears more than ⌊ n/2 ⌋ times.  
 */

/*first round*/
/*O(nlgn) after sorting the middle element is always the majority element*/
import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        return nums[n/2];
    }
}

/*second round*/
/*O(n) algorithm, but arrayList taking up too much time 
 * In each iteration, picking up two elements, if they are the same keep one, if not throw both 
 * Recurrsion ends when current list contain only one element or two different elements
 * For remained two elements, O(n) to iterate original array to find out which one is the majority
 */
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length==1) return nums[0];
        ArrayList<Integer> curr = new ArrayList<Integer>();
        for (int elem:nums)
        {
            curr.add(elem);
        }
        return helper(nums,curr);
    }
    
    public int helper(int[] nums, ArrayList<Integer> curr){
        if (curr.size()==1) return curr.get(0);
        if (curr.size()==2)
        {
            int cnt0 =0;
            int cnt1 =0;
            for (int elem:nums)
            {
                if(elem==curr.get(0))
                cnt0++;
                if(elem==curr.get(1))
                cnt1++;
            }
            if (cnt0>cnt1) return curr.get(0);
            else return curr.get(1);
        }
        
        ArrayList<Integer> rtn = new ArrayList<Integer>();
        for (int i=0;i<curr.size()-1;i=i+2)
        {
            if (curr.get(i).equals(curr.get(i + 1)))
            rtn.add(curr.get(i));
        }
        if (curr.size()%2!=0) rtn.add(curr.get(curr.size()-1));
        return helper(nums, rtn);
    } 
}

/*third round*/
/*O(n), voting algorithm */
