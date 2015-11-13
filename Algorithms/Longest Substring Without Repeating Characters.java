/* Problem: Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 */

/*4th round, using HashMap to make checking duplicates to be O(1)*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        //corner cases
        if (n<2) {
            return n;
        }
        
        //general cases
        int p1 = 0;
        int p2 = 0;
        int maxSub = 1;
        HashMap<Character, Integer> checker = new HashMap<Character, Integer>();
        outer: while (p1 < n) {
            if(checker.containsKey(s.charAt(p1))) {
                p2 = Math.max(p2, checker.get(s.charAt(p1))+1);
            }
            checker.put(s.charAt(p1), p1);
            maxSub = Math.max(maxSub, p1 - p2 + 1);
            p1++;
        }
        
        return maxSub;
        
    }
}

/*3rd round, modified brute force, not using subString*/
//checking if a char is already contained in the sliding window is the most costly part.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //corner cases
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        //general cases
        int p1 = 0;
        int p2 = 0;
        int maxSub = 1;
        int n = s.length();
        outer: while (p1 <= n - maxSub + 1) {
            p2 = p1 + 1;
            while (p2 < n) {
                for (int i = p1; i < p2; i ++){
                    if (s.charAt(i) == s.charAt(p2)) {
                        maxSub = Math.max(maxSub, p2 - p1);
                        p1 = i + 1;
                        continue outer;
                    }
                }
                p2++;
                maxSub = Math.max(maxSub, p2 - p1);
            }
            p1++;
        }
        
        return maxSub;
        
    }
}

/*2nd round, modified brute force, still too slow*/
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
        outer: while (p1 <= n - maxSub + 1) {
            p2 = p1 + 1;
            int sub = 1;
            while (p2 < n) {
                int contain = s.substring(p1, p2).indexOf(s.charAt(p2));
                if(contain >= 0) {
                    p1 = p1 + contain + 1;
                    if (sub > maxSub) {
                        maxSub = sub;
                    }                    
                    continue outer;
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