/* Problem: Binary Tree Level Order Traversal II
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * eturn its level order traversal as:
 * [[15,7],[9,20],[3]]
 */

/*2nd round, iteratively, 
 *ordinary order BFS, but result of each layer is stored in reverse order by always insert at 0-th index
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new LinkedList<List<Integer>>();
        if(root == null) return rst;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();//choose queue is because the traverse is still bottom up, only the result is stored in reverse order.
        q.add(root);
        while(!q.isEmpty()){
            int levelNum = q.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                subList.add(q.poll().val);//retrive (and remove) head of the queue and add to sublist
            }
            rst.add(0, subList);//add a new list to rst only when finishing a scan of this layer.
                                //by adding at index 0, reverse the order to bottom-up.
        }
        return rst;
    }
}

/*1st round, recursively*/
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Corner case:
        if (root == null) return rst;
        
        //General case:
        List<Integer> rootLayer = new ArrayList<Integer>();
        rootLayer.add(root.val);
        rst.add(rootLayer);
        traverse(root.left, 1);
        traverse(root.right,1);
        List<List<Integer>> rstRV = new ArrayList<List<Integer>>();
        for (int i = rst.size() - 1; i >= 0; i--) {
            rstRV.add(rst.get(i));
        }
        return rstRV;
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