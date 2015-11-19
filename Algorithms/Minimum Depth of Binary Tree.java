/* Problem: Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

/*1st round, recursively, DFS
 *simple and typical DFS problem, only need to note that it's about leaf node 
 (both its child-nodes are null)/
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
    public int minDepth(TreeNode root) {
        //if current node is null; 
        //if current node is leaf node, return 1;
        //if current node only has one child node, call recursion on that node;
        //if current node have both child-nodes,  do recursion call on both nodes and choose the smaller one.
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    
}