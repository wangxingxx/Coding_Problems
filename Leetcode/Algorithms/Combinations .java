/* Problem: Combinations 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 *[
   [2,4],
   [3,4],
   [2,3],
   [1,2],
   [1,3],
   [1,4],
 * ]
 */



public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        // Corner cases:
        if (n <= 0 || n < k) {
		    return rst;
        }
        
        // General cases:
        List<Integer> cmb = new ArrayList<Integer>();
        dfs(n, k, 1, cmb, rst);
        
        return rst;
    }
    private void dfs(int n, int k, int start, List<Integer> cmb, List<List<Integer>> rst) {
	    if (cmb.size() == k) {
		    rst.add(new ArrayList<Integer>(cmb));
		return;
	    }
 
	    for (int i = start; i <= n; i++) {
		    cmb.add(i);
		    dfs(n, k, i + 1, cmb, rst);
		    cmb.remove(cmb.size() - 1);
	    }
    }
}