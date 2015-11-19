/*Problem: Implement Trie (Prefix Tree)*/

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