/* Problem: Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, 
 * a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        
        if (root==null) return true;
        if (height(root)<0) return false;
        return true;
    }
    public int height(TreeNode root) {
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1) return -99;
        if(left < 0 || right < 0) return -99;
        else return Math.max(left,right)+1;
    }
    
}
