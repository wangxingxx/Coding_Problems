/* Problem: Populating Next Right Pointers in Each Node II
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *        1
 *      /  \
 *     2    3
 *    / \    \
 *   4   5    7
 * After calling your function, the tree should look like:
 *       1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 */

/*2nd round, BFS, three pointers*/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    //based on level order traversal
    public void connect(TreeLinkNode root) {

        TreeLinkNode levelHead = null; //levelHead of the next level
        TreeLinkNode levelPrev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {

            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (levelPrev != null) {
                        //if levelPrevious == null, means cur.left is the first node of this level
                        //if levelPrevious != null, means cur.left should be connected to levelPrevious node.
                        levelPrev.next = cur.left;
                    } else {
                        levelHead = cur.left;//set levelHead to the first node of this level.
                    }
                    levelPrev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (levelPrev != null) {
                        levelPrev.next = cur.right;
                    } else {
                        levelHead = cur.right;
                    }
                    levelPrev = cur.right;
                }
                //move to next node
                cur = cur.next;//this is using the build connection from previous level.
                //at the end, cur will be the right-most node of this level, and thus cur.next == null, by assigning cur= cur.next makes cur = null. Then inner loop ends.
            }

            //move to next level
            //when inner loop ends, set cur to the left-most node of this scaned level, and prepare to scan the next level.
            cur = levelHead;
            levelHead = null;
            levelPrev = null;
        }

    }
}

/*1st round, DFS*/
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