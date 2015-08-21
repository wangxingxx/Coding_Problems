/* Problem: Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */

 /* Valid Anagram contain the same characters and the same numbers of them.*/

 /*1st round, works but time complexity is not good*/
 public class Solution {
    public boolean isAnagram(String s, String t) {
        //corner cases
        if (s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.length()!=t.length()) return false;
        
        int n = s.length();
        int[] checker = new int[n];
        char sc;
        char tc;
        for(int i=0; i<n; i++){
            sc = s.charAt(i);
            boolean fd = false;
            for(int j=0;j<n;j++){
                tc = t.charAt(j);
                if(sc==tc && checker[j]==0){
                    checker[j]=1;
                    fd = true;
                    break;
                }
            }
            if(fd==false) return false;
        }
        for (int i=0; i<n; i++){
            if(checker[i]!=1) return false;
        }
        return true;
    }
}