/* Problem: Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * eturn its level order traversal as:
 * [[3],[9,20],[15,7]]
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
    List<List<Integer>> rst = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Corner case:
        if (root == null) return rst;
        
        //General case:
        List<Integer> rootLayer = new ArrayList<Integer>();
        rootLayer.add(root.val);
        rst.add(rootLayer);
        traverse(root.left, 1);
        traverse(root.right,1);
        return rst;
    }
    
    public void traverse(TreeNode node, int layer) {
        if (node == null) return;
        if (rst.size() < layer + 1) {
            List<Integer> layerLst = new ArrayList<Integer>();
            layerLst.add(node.val);
            rst.add(layerLst);
        } else {
            rst.get(layer).add(node.val);
        }
        traverse(node.left, layer+1);
        traverse(node.right, layer+1);
    }
}

