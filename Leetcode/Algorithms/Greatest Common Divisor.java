/*Problem: compute the Greatest Common Divisor of two numbers*/

/*Euclidean algorithm*/
public class Solution {
	public int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b, a%b);
	}
}

