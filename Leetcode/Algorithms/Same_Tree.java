/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical 
 * and the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null) return false;
        if(q==null&&p!=null) return false;
        if(p==null&&q==null) return true;
        if(p.val!=q.val) return false;
        return (isSameTree(p.left,q.left)&&isSameTree(p.right,q.right));
    }
}