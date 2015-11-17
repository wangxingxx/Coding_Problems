/* Problem: Sqrt(x)
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */


/*1st round, binary search. O(lgn)*/
public class Solution {
    public int mySqrt(int x) {
        
        double start = -1;
        double end = (double)x+1; //cannot use double(x + 1), but why?
        //set the range larger than (0,x) is to make sure the loop invariant:
        // start <= target < end is always true; 
        // this means, end will always point to number that is larger than target, while start will point to numbers smaller or equal to the target.
        //with the following loop condition, when search ends, start will be right next to end and the number is points (say s) will be the largest number that is <= target, while the right next number is already > target. 
        // Therefore start will point to the target.
        // Also, square root of s any number x has that s * s <= x; 
        while (end - start > 1) {
        //this condition forces that when loop ends, start is right next to end but not equal to end.
            double mid = Math.floor((start + end) / 2);
            
            if ( mid * mid > x) {
                end = mid;
            }else {
                start = mid;
            }
        }
        
        return (int)start;
    }
}