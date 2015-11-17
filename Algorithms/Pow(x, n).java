/* Problem: Pow(x, n)
 * Implement pow(x, n).
 */


/*2nd round, iteratively, 
 *note that, loop ends at n==1, to make sure rst always gets assigned.
 *for an odd n, rst will be assigned twice to maintain the additional one time of muliply x 
 */
  	public class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || x == 0 || n == 1) return x;
        if (n == 0) return 1;
        
        if (n < 0) { 
            n = -n;
            x = 1/x;
        }
        
        double rst = 1;
        
        while (n > 0) {
            if (n % 2 != 0) {
                rst *= x;//for an odd power, only have to keep one copy of current x for later to use. 
                        // also for any n > 0, this will be reached at least once when n == 1.
            }
            x *= x;
            n >>= 1;//n = n/2;
        }
        
        return rst;
        
    }
}

/*1st round, reccursively, note that, n can be negative power*/
public class Solution {
    public double myPow(double x, int n) {
        if (x == 1 || x == 0 || n == 1) return x;
        if (n == -1) return 1/x;
        if (n == 0) return 1;
        double rst = myPow(x, n/2);
        
        if (n % 2 == 0) return rst * rst;
        return n < 0 ? rst * rst * 1/x : rst * rst * x;
    }
}