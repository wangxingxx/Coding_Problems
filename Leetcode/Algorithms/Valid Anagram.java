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

/*2nd round, better time complexity with two extra arrays.*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        //corner cases
        if (s==null && t==null) return true;
        if (s==null || t==null) return false;
        if (s.length()!=t.length()) return false;
        int n=s.length();
        if (n==0) return true;
        
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        int sID = -1;
        int tID = -1;
        for(int i=0; i<n; i++){
            sID = helper(s.charAt(i));
            tID = helper(t.charAt(i));
            sCount[sID]++;
            tCount[tID]++;
        }
        for(int i=0; i<26; i++){
            if(sCount[i]!=tCount[i]) return false;
        }
        return true;
    }
    public int helper(char c){
        switch(c){
            case 'a': return 0;
            case 'b': return 1;
            case 'c': return 2;
            case 'd': return 3;
            case 'e': return 4;
            case 'f': return 5;
            case 'g': return 6;
            case 'h': return 7;
            case 'i': return 8;
            case 'j': return 9;
            case 'k': return 10;
            case 'l': return 11;
            case 'm': return 12;
            case 'n': return 13;
            case 'o': return 14;
            case 'p': return 15;
            case 'q': return 16;
            case 'r': return 17;
            case 's': return 18;
            case 't': return 19;
            case 'u': return 20;
            case 'v': return 21;
            case 'w': return 22;
            case 'x': return 23;
            case 'y': return 24;
            case 'z': return 25;
            default: return -1;
        }
    }
}