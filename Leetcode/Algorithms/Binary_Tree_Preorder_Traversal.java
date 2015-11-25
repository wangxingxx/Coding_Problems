/**
 * Problem:
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
    List<Integer> rst = new ArrayList<Integer>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if (root==null) return rst;
        rst.add(root.val);
        if(root.left!=null) preorderTraversal(root.left);
        if(root.right!=null) preorderTraversal(root.right);
        return rst;
    }
}