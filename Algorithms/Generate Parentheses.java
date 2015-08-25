/* Problem: Generate Parentheses
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */


/*1st round*/
public class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>(); 
        helper(n,n,rst,"");
        return rst;
    }
    public void helper (int left, int right, List<String> rst, String s) {
        if(left>right) return;
        if(left==0 && right ==0){
            rst.add(s);
            return;
        }
        if(left > 0){
            //bdr.append(")");
            helper(left-1,right,rst,s+"(");
        }
        if(right>0) {
            helper(left,right-1,rst,s+")");
        }
        
    }
}