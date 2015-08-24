/**
 * Problem: Binary Tree Postorder Traversal 
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */


/*1st round, with recursion.*/

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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return rst;
        if (root.left==null && root.right==null) {
            rst.add(root.val);
            return rst;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        rst.add(root.val);
        return rst;
    }

}