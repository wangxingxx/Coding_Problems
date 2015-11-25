/*Problem: Permutation II
 *Given a collection of numbers that might contain duplicates, 
 *return all possible unique permutations.
 *For example,
 *[1,1,2] have the following unique permutations:
 *[1,1,2], [1,2,1], and [2,1,1].
 */



/*1st round, based on idea from Permutation I, adding a step of sorting num and skip duplcates once the first occurance is handled*/
public class Solution {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> p = new ArrayList<Integer>();
    int[] num;
    int n;
    int[] visited;

    public List<List<Integer>> permuteUnique(int[] num) {
        this.num = num;
        Arrays.sort(num);//sort num first and then the duplicates will be skipped
        n = this.num.length;
        visited = new int[n];//inital state all zeros.
        subpermute();
        return rst;
    }
    
    private void subpermute(){
        if(p.size() == n) {
            rst.add(new ArrayList<Integer>(p));
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                p.add(num[i]);
                subpermute();
                visited[i] = 0;
                p.remove(p.size()-1);
                while(i < n - 1 && num[i] == num[i+1]) {
                //once the first of the repeating numbers is handled, the duplicates occure later will be skipped
                    i++;
                }
            }
             
        }
    }
}