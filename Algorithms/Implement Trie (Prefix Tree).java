/*Problem: Implement Trie (Prefix Tree)*/

/*4th round, recursive, DFS but no need to reverse by always inserting at 0th index. 
 *Slower then the 3rd round that reverse at last step, 
large problem size shouldnot use this one*/
public class Solution {
     List<List<Integer>> rst = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Corner case:
        if (root == null) return rst;
        
        traverse(root,0);
        return rst;
    }
    
    public void traverse(TreeNode node, int layer) {
        if (node == null) return;
        int n = rst.size();
        if (n < layer + 1) {
            List<Integer> layerLst = new ArrayList<Integer>();
            layerLst.add(node.val);
            rst.add(0,layerLst);
        } else {
            rst.get(n-layer-1).add(node.val);
        }
        traverse(node.left, layer+1);
        traverse(node.right, layer+1);
    }
}

/*3rd round, recursive, DFS then reverse the rst list, 1ms, beats 99.37*/
public class Solution {
     List<List<Integer>> rst = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Corner case:
        if (root == null) return rst;
        
        traverse(root,0);
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

/*2nd round, used HashMap, slower than array, poor data structure choide*/
class TrieNode {
    //public char val; //interestingly, the value of each node itself doesn't matter, as long as it's associated with its parent's children array.
    public boolean isLeaf; 
    public HashMap<Character,TrieNode> children = new HashMap<Character,TrieNode>();
    public TrieNode() {}
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode cur = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) return false;
             cur = cur.children.get(c);
        }
        return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c)) return false;
            cur = cur.children.get(c);
        }
        return true;// difference with searching for word than searching for prefix is that the end node doesn't need to be leaf.
    }
}

/*1st round, each node has: a char array with size of 26, and a boolean to indicate if it's a leaf node.*/
class TrieNode {
    //public char val; //interestingly, the value of each node itself doesn't matter, as long as it's associated with its parent's children array.
    public boolean isLeaf; 
    public TrieNode[] children = new TrieNode[26];//initial state with all null, index = the letter - 'a'
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        //node.val = c;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        //root.val = ' ';
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        TrieNode cur = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;// difference with searching for word than searching for prefix is that the end node doesn't need to be leaf.
    }
}