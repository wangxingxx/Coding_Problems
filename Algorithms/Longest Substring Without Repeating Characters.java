/* Problem: Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */


/*1st round, brute force, too slow for large input*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //corner cases
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        //general cases
        int p1 = 0;
        int p2 = 0;
        int maxSub = 0;
        int n = s.length();
        while (p1 <= n - maxSub + 1) {
            p2 = p1 + 1;
            int sub = 1;
            while (p2 < n) {
                if(s.substring(p1, p2).indexOf(s.charAt(p2))>=0) {
                    break;
                } else {
                    sub++;
                    p2++;
                }
            }
            if (sub > maxSub) {
                maxSub = sub;
            }
            p1++;
        }
        
        return maxSub;
        
    }
}