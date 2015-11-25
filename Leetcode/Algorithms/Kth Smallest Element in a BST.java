/* Problem: Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often 
 * and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */

/*3rd round, modifed in-order traverse in 1st round. faster but not good if tree changes frequently*/
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
    int count = 0;
    int rst = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        //General case:
        count = k;
        rst = root.val;
        traverse(root);
        return rst;
    }
    
    public void traverse(TreeNode root){
        if (root == null) return;
        
        traverse(root.left);
        count--;// Everytime reaches a left child node, count--;
        if(count == 0) {
            rst = root.val;
            return;
        }
        traverse(root.right);
        
    }
}

/*2nd round, binary search and O(1) extra memory, faster but not good if the tree changes frequently*/
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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }

        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;

        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}


/*1st round, in-order traverse and use extra ArrayList, good for frequently modified tree*/
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
    ArrayList<Integer> rst = new ArrayList<Integer>();
    
    public int kthSmallest(TreeNode root, int k) {
        
        //General case:
        traverse(root);
        return rst.get(k-1);
    }
    
    public void traverse(TreeNode root){
        if (root == null) return;
        
        traverse(root.left);
        rst.add(root.val);
        traverse(root.right);
    }
}