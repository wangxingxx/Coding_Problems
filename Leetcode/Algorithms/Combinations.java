/* Problem: Combinations
 * Given two integers n and k, 
 * return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 *[
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 *]
*/

/*
 * 2nd round, recurrsively, faster and removed unnessary state
 * by using j to limit we only look forward to numbers behind current numbers 
 * can achieve the goal to avoid duplicates. 
 */
public class Solution {
	private List<List<Integer>> rst = new ArrayList<List<Integer>>();
	private List<Integer> entry = new ArrayList<Integer>();
	private int[] num;

	private int n;
	private int k;

	public List<List<Integer>> combine(int n, int k) {
		// if (n < k ) return rst;
		this.num = new int[n];
		this.n = n;
		this.k = k;
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}
		dfs(0);
		return rst;
	}

	private void dfs(int start) {

		if (entry.size() == k) {
			rst.add(new ArrayList<Integer>(entry));
			return;
		}
		for (int j = start; j < n; j++) {

			entry.add(num[j]);
			dfs(j + 1);
			entry.remove(entry.size() - 1);

		}
	}
}




/*1st round, recurrsively, similar idea of Permutation.
 * using dfs to find all possible ways to insert new number
 * but have additional edge condition: new number must larger than the previous number
 * converge when the length of current entry reaches the size required.
 */
public class Solution {
	private List<List<Integer>> rst = new ArrayList<List<Integer>>();
	private List<Integer> entry = new ArrayList<Integer>();
	private int[] num;
	private int[] visited;
	private int n;
	private int k;

	public List<List<Integer>> combine(int n, int k) {
		this.num = new int[n];
		this.n = n;
		this.k = k;
		for (int i = 0; i < n; i++) {
			num[i] = i + 1;
		}
		visited = new int[n];
		// initial state to be all zeros which means all numbers haven’t been
		// visited/used.
		dfs(0);
		return rst;
	}

	private void dfs(int start) {

		if (entry.size() == k) {
			rst.add(new ArrayList<Integer>(entry));
			return;
		}
		// if (start >= n - 1) return;
		for (int j = start; j < n; j++) {
			if (visited[j] == 0 && (entry.size() == 0 || entry.get(entry.size() - 1) < num[j])) {
				visited[j] = 1;
				entry.add(num[j]);
				dfs(start + 1);
				visited[j] = 0;
				entry.remove(entry.size() - 1);
			}
		}
	}
}
