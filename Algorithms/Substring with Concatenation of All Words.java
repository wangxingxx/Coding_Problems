
/* Problem: Substring with Concatenation of All Words
 * You are given a string, s, and a list of words, words, that are all of the same length
 * Find all starting indices of substring(s) in s 
 * that is a concatenation of each word in words exactly once 
 * and without any intervening characters.
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter)
 */


/*2nd round, using two hashMaps, does the job, OJ still thinks it's too slow, but it's only 70ms for the "failed" test case*/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //alg:
        //extra HashMap to count remaining word in words.
        //use two pointers to create a sliding window of length == len(word) in words.
        //check in HashMap if words element is found, and update the counter
        //if a word in current sliding window is not in HashMap.keys, or if a counter is < 0,
        // HashMap back to the original and window moves a step a head.
        
        
        //corner case:
        //null, empty, s shorter then the total length of words
        if (s == null || words == null) {
            return null;
        }
        
        int sl = s.length();
        int wn = words.length;
        
        if(sl == 0 || wn == 0) {
            return null;
        }
        
        int wl = words[0].length(); 
        if(sl < wn * wl) {
            return null;
        }
        
        //general case:
        List<Integer> rst = new ArrayList<Integer>();
        HashMap<String, Integer> wCounter = new HashMap<String, Integer>();
        for (String w : words) {
            if (!wCounter.containsKey(w)){
                wCounter.put(w, 1);
            } else {
                wCounter.put(w, wCounter.get(w)+1);
            }
        }
        
        String[] sWords = new String[sl - wn * wl];
        for (int i = 0; i < sWords.length; i++) {
            sWords[i] = s.substring(i, i + wl * wn);
        }
        
        HashMap<String, Integer> swCounter;
        int index;
        String curr;
        for (int j = 0; j < sWords.length; j++) {
            swCounter = new HashMap<String, Integer>();
            index = 0;
            while (index < wn * wl) {
                curr = sWords[j].substring(index, index + wl);
                if (!swCounter.containsKey(curr)){
                    swCounter.put(curr, 1);
                } else {
                    swCounter.put(curr, swCounter.get(curr)+1);
                }
                
                index += wl;
            }
            
            if (swCounter.equals(wCounter)) {
                rst.add(j);
            }
        }
        
        return rst;
    }
}

/*1st round, using hashMap and two pointers, OJ thinks it's too slow*/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //alg:
        //extra HashMap to count remaining word in words.
        //use two pointers to create a sliding window of length == len(word) in words.
        //check in HashMap if words element is found, and update the counter
        //if a word in current sliding window is not in HashMap.keys, or if a counter is < 0,
        // HashMap back to the original and window moves a step a head.
        
        
        //corner case:
        //null, empty, s shorter then the total length of words
        if (s == null || words == null) {
            return null;
        }
        
        int sl = s.length();
        int wn = words.length;
        
        if(sl == 0 || wn == 0) {
            return null;
        }
        
        int wl = words[0].length(); 
        if(sl < wn * wl) {
            return null;
        }
        
        //general case:
        HashMap<String, int[]> counter = new HashMap<String, int[]>();
        for (String w : words) {
            if (!counter.containsKey(w)){
                counter.put(w,new int[]{1,1});//second element in value array is the back up of original counter record to recover.
            } else {
                counter.get(w)[0] = counter.get(w)[0]+1;
                counter.get(w)[1] = counter.get(w)[0];
            }
        }
        
        int p1 = 0;
        int p2 = p1 + wl - 1;// sliding window.
        int remain = wn; //remain words to find in words
        List<Integer> rst = new ArrayList<Integer>();
        int index = p1;
        String curr = "";
        while (p2 < sl) {
            curr = s.substring (p1, p2+1);
            if (counter.containsKey(curr) == false) {
                for (int[] val : counter.values()) {
                    val[0] = val[1];
                }
                p1 = index + 1;
                p2 = p1 + wl - 1;
                remain = wn;
                index = p1;
                continue;
            }
            
            counter.get(curr)[0] = counter.get(curr)[0] - 1;
            if (counter.get(curr)[0] < 0) {
                for (int[] val : counter.values()) {
                    val[0] = val[1];
                }
                p1 = index + 1;
                p2 = p1 + wl - 1;
                remain = wn;
                index = p1;
                continue;
            }
            remain--;
            p2 += wl;
            p1 += wl;
            if (remain == 0) {
                rst.add(index);
                for (int[] val : counter.values()) {
                    val[0] = val[1];
                }
                p1 = index + 1;
                p2 = p1 + wl - 1;
                remain = wn;
                index = p1;
            }
        }
        
        return rst;
    }
}