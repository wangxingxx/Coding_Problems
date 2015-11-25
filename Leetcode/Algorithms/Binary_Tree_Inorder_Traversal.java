/**
 * Problem:
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        if (root==null) return rst;
        if(root.left!=null) inorderTraversal(root.left);
        rst.add(root.val);
        if(root.right!=null) inorderTraversal(root.right);
        return rst;
    }
}