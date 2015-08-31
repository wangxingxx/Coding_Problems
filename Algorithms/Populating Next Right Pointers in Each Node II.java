/* Problem: Populating Next Right Pointers in Each Node II
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note: You may only use constant extra space.
 *



/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.left!=null && root.right!=null) {
            root.left.next = root.right;
            TreeLinkNode itr = root.next;
            if (itr==null) root.right.next =null;
            else {
                root.right.next =null;
                while(itr!=null){
                    if(itr.left!=null) {
                        root.right.next=itr.left;
                        break;
                    }
                    if(itr.right!=null) {
                        root.right.next=itr.right;
                        break;
                    }
                    itr=itr.next;
                }
            }
        }
        //root.left==null && root.right!=null
        else if (root.left==null){
            TreeLinkNode itr = root.next;
            if (itr==null) root.right.next =null;
            else {
                root.right.next =null;
                while(itr!=null){
                    if(itr.left!=null) {
                        root.right.next=itr.left;
                        break;
                    }
                    if(itr.right!=null) {
                        root.right.next=itr.right;
                        break;
                    }
                    itr=itr.next;
                }
            }
        }
        //root.right==null&&root.left!=null
        else {
            TreeLinkNode itr = root.next;
            if (itr==null) root.left.next =null;
            else {
                root.left.next =null;
                while(itr!=null){
                    if(itr.left!=null) {
                        root.left.next=itr.left;
                        break;
                    }
                    if(itr.right!=null) {
                        root.left.next=itr.right;
                        break;
                    }
                    itr=itr.next;
                }
            }
        }
        
        //must deal with right sub-tree first
        connect(root.right);
        connect(root.left);
    }
}