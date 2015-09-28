/* Problem: Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 */

/*1st round, brute force*/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        //Brute force
        if (n == 1) return true;
        if (n < 2) return false;
        
        while (n > 1) {
            if (n % 2 != 0) return false;
            else {
                n = n/2;
            }
        }
        
        return true;
        
    }
}