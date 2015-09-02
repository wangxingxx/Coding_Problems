/* Problem: Symmetric Tree
 * Given a binary tree, check whether it is a mirror of itself 
 * (ie, symmetric around its center).
 */




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
    public boolean isSymmetric(TreeNode root) {
        //ALG:
        //Using two pointer (curL and curR) to iterate the left & right side of the tree,
        //curL iterates in left-right order, curR iterates in right-left order.
        //For each two current nodes (those curL and curR point at),
        //If both are null, we return the leaves, return true;
        //If the vals are not equal, return false;
        //If the vals are equal, recursively checking if their sub-Trees (and sub-sub-Trees) are symmetric, if so return true, otherwise return false.

        //corner cases:
        if (root == null) {
            return true;
        }
        
        //general cases:
        return subSymmetric(root.left, root.right);
    }
    
    public boolean subSymmetric(TreeNode curL, TreeNode curR) {
        if (curL == null && curR == null) {
            return true;
        } else if (curL == null || curR == null) {
            return false;
        }
        
        if (curL.val != curR.val) {
            return false;
        } else {
            return subSymmetric(curL.left, curR.right) && subSymmetric(curL.right, curR.left);
        }
    }
}



/*2nd round, iteratively, using queue*/
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
    public boolean isSymmetric(TreeNode root) {
        //Corner cases:
        if(root == null) {
            return true;
        }
        
        //General cases:
        Queue<TreeNode> lq = new LinkedList<TreeNode>();
        Queue<TreeNode> rq = new LinkedList<TreeNode>();
        lq.add(root.left);
        rq.add(root.right);
        TreeNode leftTemp = null;
        TreeNode rightTemp = null;
        while(!lq.isEmpty() && !rq.isEmpty()){
            leftTemp = lq.poll();
            rightTemp = rq.poll();
            if(leftTemp == null && rightTemp == null) {
                continue;
            } else if(leftTemp == null || rightTemp == null) {
                return false; 
            }
            
            if(leftTemp.val != rightTemp.val) {
                return false;
            }
            
        //Left side iteration follows left-right order; Right side iteration follows right-left order.
            lq.add(leftTemp.left);
            lq.add(leftTemp.right);
            rq.add(rightTemp.right);
            rq.add(rightTemp.left);
        }
        
        return true;
        
    }
}