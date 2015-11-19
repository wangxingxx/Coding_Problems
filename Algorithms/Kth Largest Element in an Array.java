/* Problem: Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */


/*1st round, using Java PriorityQueue, O(nlogk)*/
public class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largeK = new PriorityQueue<Integer>(k + 1);
        //priorityqueue buid O(n), offer, poll, remove head, add are all O(lgn); remove(given element) and contains(given element) are all O(n); peek or element(get the head element) and size are all O(1) 

        for(int el : nums) {
            largeK.add(el);
            if (largeK.size() > k) {
                largeK.poll();//Retrieves and removes the head of this queue, which is the K-th largest element so far.
            }
        }

        return largeK.poll();
    }
}