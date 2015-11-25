/** Problem: Implement strStr()
  * Implement strStr().
  * Returns the index of the first occurrence of needle in haystack, 
  * or -1 if needle is not part of haystack.
  */

/*2nd round, compare substring hash code value, running time improved but still O(mn)*/
public class Solution {
    public int strStr(String haystack, String needle) {
        //corner cases
        if(haystack == null || needle == null) {
            return -1;
        }
        if(needle.isEmpty()) {
            return 0;
        }
        int hl = haystack.length();
        int nl = needle.length();
        if (nl > hl) {
            return -1;
        }
        
        //general cases
        int p1 = 0;
        String sub;
        int nHash = needle.hashCode();
        while(p1 <= hl-nl){
            if(haystack.charAt(p1) == needle.charAt(0)){
                sub = haystack.substring(p1,p1+nl);
                if (sub.hashCode() == nHash) {
                    return p1;
                }
            } 
            p1++;
        }
        
        return -1;
        
        
    }
}

/*1st round, brute force*/
public class Solution {
    public int strStr(String haystack, String needle) {
        //corner cases
        if(haystack == null || needle == null) {
            return -1;
        }
        if(needle.isEmpty()) {
            return 0;
        }
        int hl = haystack.length();
        int nl = needle.length();
        if (nl > hl) {
            return -1;
        }
        
        //general cases
        int p1 = 0;
        int p2 = 0;
        outer: while(p1 <= hl-nl){
            if(haystack.charAt(p1) == needle.charAt(0)){
                p2 = p1;
                while(p2-p1 <= nl-1){
                    if(haystack.charAt(p2) != needle.charAt(p2-p1)) {
                        p1++;
                        continue outer;
                    }
                    p2++;
                }
                return p1;
            } else {
                p1++;
            }
        }
        
        return -1;
        
        
    }
}