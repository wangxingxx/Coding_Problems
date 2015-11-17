/* Problem: Pow(x, n)
 * Implement pow(x, n).
 */

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