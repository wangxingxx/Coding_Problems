/* Problem: Gray Code
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00,01,11,10.
 */

 /* Thoughts:
  * n=k时的Gray Code，相当于n=k-1时的Gray Code的逆序 加上 1<<(k-1) 
  * For example:
  * n=2, 00,01,11,10;
  * n=3, 000,001,011,010,110,111,101,100;
  */

 public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> helper = new ArrayList<Integer>();
        helper.add(0);
        if(n==0) return helper;
        
        helper.add(1);
        if(n==1) return helper;
        else {
            List<Integer> rst = new ArrayList<Integer>(grayCode(n-1));
            int m=rst.size();
            for(int i=m-1;i>=0;i--){
                rst.add(rst.get(i)+(1<<(n-1)));
            }
            return rst;
        }
    }
}