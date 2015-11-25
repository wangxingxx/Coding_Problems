/* Problem: Permutations
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */

/*1st round, using dfs to recursively solve it*/
public class Solution {
    public List<List<Integer>> permute(int[] num) {
        
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        int[] used = new int[num.length];
        int depth = num.length;
        
        dfs(num, used, depth, tmp, rst);
        
        return rst;
    }
    
    //dfs find all solution
    public void dfs(int[] num, int[] used, int depth, List<Integer> tmp, List<List<Integer>> rst){
        if(depth==0){
            rst.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<num.length; i++){
            //skip if current number is used
            if(used[i]==1) continue;
            used[i] = 1;
            tmp.add(num[i]);
            dfs(num, used, depth-1, tmp, rst);
            used[i] = 0;
            tmp.remove(tmp.size()-1);
        }
    }
}