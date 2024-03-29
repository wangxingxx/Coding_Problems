/*Problem: Permutation
 *Given a collection of numbers, return all possible permutations.
 *For example,
 *[1,2,3] have the following permutations:
 *[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */


/*4th round, recurrsively,
 * using the same idea of 2nd round, using insertion to create permutations
 */
public class Solution {
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    List<Integer> p = new ArrayList<Integer>();
    int[] num;
    int n;
    int[] visited;

    public List<List<Integer>> permute(int[] num) {
        this.num = num;
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
            }
        }
    }

}

/*3rd round, recurrsively, 
by making all possible swaps on original list to create variation as new permutation
this alg faster for this problem, 
and using much less extra space by using global variables */
    public class Solution {    
       List<List<Integer>> rst = new ArrayList<List<Integer>>();
       int[] numcopy;
       int n;
    public List<List<Integer>> permute(int[] num) {
        numcopy = num;
        n = numcopy.length;
        subPermute(0);
        return rst;
    }
    
    private void subPermute(int start){
        
        if(start >= n) {
            List<Integer> perm = new ArrayList<Integer>();
            for(int elm : numcopy) {
                perm.add(elm);
            }
            rst.add(perm);
        } else {
            for(int i = start; i < n; i++) {
                swap(start, i);
                subPermute(start+1);
                swap(start, i);
            }
        }
    }
    
    private void swap(int i, int j){
        int tmp = numcopy[i];
        numcopy[i] = numcopy[j];
        numcopy[j] = tmp;
    }
}

/*2nd round, minor change in inner loop 
(copy pm first then add new number, so don't need to roll back)
to clean up the logic flow.*/
public class Solution {    
    
    public List<List<Integer>> permute(int[] num) {
        
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        rst.add(new ArrayList<Integer>());
        
        //nested three loops do the following:
        //outer loop scan each number in num, and update rst list. O(n)
        //mid loop scan the rst list and take out each permutation already in the rst
        //inner loop scann all possible positions for adding the new number to that permutation. O(n) because the length of permutation is at most n.
        //after adding the new number to each position, inner loop also saves new permutation in temporary result list called current. O(n) because the length of permutation is at most n.
        //out loop then saves that result to rst, and move to next number in num.
        
        for (int i = 0; i < num.length; i++) {
            List<List<Integer>> tmpRst = new ArrayList<List<Integer>>();
            for (List<Integer> pm : rst) {
                for (int j = 0; j < pm.size() + 1; j++) {
                    List<Integer> tmpPm = new ArrayList<Integer>(pm);
                    tmpPm.add(j, num[i]);
                    tmpRst.add(tmpPm);
                }
            }
            
            rst = new ArrayList<List<Integer>>(tmpRst);
        }
        
        return rst;
    }
    
}

/*1st round, iteratively, use extra lists to hold temporary results, O(n^3) */
public class Solution {
    
    public List<List<Integer>> permute(int[] num) {
        
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        
        rst.add(new ArrayList<Integer>());
        
        //nested three loops do the following:
        //outer loop scan each number in num, and update rst list. O(n)
        //mid loop scan the rst list and take out each permutation already in the rst
        //inner loop scann all possible positions for adding the new number to that permutation. O(n) because the length of permutation is at most n.
        //after adding the new number to each position, inner loop also saves new permutation in temporary result list called current. O(n) because the length of permutation is at most n.
        //out loop then saves that result to rst, and move to next number in num.
        outer: for (int i = 0; i < num.length; i++) {
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            mid: for (List<Integer> pm : rst) {
                inner: for (int j = 0; j < pm.size() + 1; j++) {
                    pm.add(j, num[i]);
                    List<Integer> tmp = new ArrayList<Integer>(pm);
                    current.add(tmp);
                    pm.remove(j);
                    //to roll back to old permutation to be able to add number to next possible position
                }
            }
            
            rst = new ArrayList<List<Integer>>(current);
        }
        
        return rst;
    }
    
}