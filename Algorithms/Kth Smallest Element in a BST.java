/* Problem: Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often 
 * and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ArrayList<Integer> rst = new ArrayList<Integer>();
    
    public int kthSmallest(TreeNode root, int k) {
        
        //General case:
        traverse(root);
        return rst.get(k-1);
    }
    
    public void traverse(TreeNode root){
        if (root == null) return;
        
        traverse(root.left);
        rst.add(root.val);
        traverse(root.right);
    }
}