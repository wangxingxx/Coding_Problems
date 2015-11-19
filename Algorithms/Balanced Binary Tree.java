/* Problem: Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, 
 * a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */

/*2nd round, dfs but with no corner case, 
and used Integer.MIN_VALUE to handle extreme large tree situation*/
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
        return height(root) >= 0;
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        int l = height(root.left);
        int r = height(root.right);
        if (l < 0 || r < 0 || Math.abs(l-r) > 1 ) {
            return Integer.MIN_VALUE;//smallest value;
        }
        return Math.max(l,r) + 1;
        
    }
    
}

/*1st round, dfs and sum up the length by add from the bottom*/
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
