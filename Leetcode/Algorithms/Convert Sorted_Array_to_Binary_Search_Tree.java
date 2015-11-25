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
    TreeNode rtn = new TreeNode(-1);
    int[] passNums;
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        int n = nums.length;
        if(n==1) return new TreeNode(nums[0]);
        passNums=new int[n];
        for(int i=0;i<n;i++)
        {
            passNums[i]=nums[i];
        }
        return helper(0,n-1,rtn);
    }
    public TreeNode helper(int start, int end, TreeNode currNode){
        if(start>end) return null;
        int n=end-start+1;
        if(n==1) return new TreeNode(passNums[start]);
        currNode.val=passNums[start+n/2];
        currNode.left=helper(start,start+n/2-1,new TreeNode(-1));
        currNode.right=helper(start+n/2+1,end,new TreeNode(-1));
        return currNode;
    }
}