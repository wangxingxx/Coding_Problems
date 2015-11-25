/* Problem: Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S 
 * which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, 
 * return the empty string "".
 * If there are multiple such windows, 
 * you are guaranteed that there will always be only one unique minimum window in S.
 */

 /*first round, using hashMap, but incorrect interpreation of the problem. When S = "baa", T="aa", should return "aa" not only "a"*/
public class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        //corner cases
        if(n < m || m==0) {
            return "";
        }
        
        //general cases

        HashMap<Character, ArrayList<Integer>> charHash = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(!charHash.containsKey(c)) {
                charHash.put(c,new ArrayList<Integer>());
            }
            charHash.get(c).add(i);
        }
        
        int lmax = -1;
        int lmin = n;
        int hmax = -1;
        int hmin = n;
        for(int j = 0; j < m; j++) {
            char cc = t.charAt(j);
            if (!charHash.containsKey(cc)) {
                return "";
            }
            ArrayList<Integer> indexLst = charHash.get(cc);
            lmax = Math.max(indexLst.get(0), lmax);
            lmin = Math.min(indexLst.get(0), lmin);
            hmax = Math.max(indexLst.get(indexLst.size()-1), hmax);
            hmin = Math.min(indexLst.get(indexLst.size()-1), hmin);
        }
        
        if (lmax-lmin < hmax - hmin) {
            return s.substring(lmin, lmax+1);
        }else return s.substring(hmin, hmax+1);
    }
}