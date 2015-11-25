/**Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.**/
public class Solution {
    public int maxSubArray(int[] A) {
        //calculate current sum while traversing
        //if current sum <0, then drop the current sum of previous elements, but start a new summation from the next element.
        if (A.length==0) return 0;
        int curSum=0;
        int max=A[0];
        for (int elm:A){
            if (curSum<0) curSum=0;
            curSum+=elm;
            if(curSum>max) max=curSum;
        }
        return max;
    }
}