/* Problem: H-Index II
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 */

public class Solution { 
	public int hIndex (int[] citations) {
		// Corner cases:
		if (citations == null || citations.length == 0) {
	        return 0;
        }
		
		// General cases:
		int n = citations.length;
		int left = 0;
		int right = n - 1;
		int mid = 0;
		while (left <= right) {
		    mid = (left + right) >> 1;
		    if (citations[mid] == (n -  mid)) {
		        return n - mid;
		    } else if (citations[mid] > n-mid) {
		        right = mid - 1;
		    } else left = mid + 1;
		}
		return n - (right + 1);
	}
	
}


