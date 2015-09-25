/* Problem: Ugly Number
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 */


public class Solution {
    public boolean isUgly(int num) {
        //Corner cases:
        if (num == 0) return false;
        if (num == 1 || num == 2 || num == 3 || num == 5) return true;
        
        if (num % 2 == 0) {
            int res = num/2;
            if (isNotUglyPrime(res)) {
                return false;
            } else return isUgly(res);
        }
        if (num % 3 == 0) {
            int res = num/3;
            if (isNotUglyPrime(res)) {
                return false;
            } else return isUgly(res);
        }        
        if (num % 5 == 0) {
            int res = num/5;
            if (isNotUglyPrime(res)) {
                return false;
            } else return isUgly(res);
        } 
        
        return false;
        
        
    }
    
    public boolean isNotUglyPrime (int num) {
        if (num == 2 || num == 3 || num == 5) {
            return false;
        }
        if (num < 2) {
            return false;
        }
        //check if n is a multiple of 2
        if (num > 2 && num % 2 == 0) {
            return false;
        }
        //if not, then just check if num can be divided by the odds. 
	    //because if num is divided by an even number, then it must also be divided by 2
        for (int i = 3; i*i <= num; i=i+2) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
        
    }
}