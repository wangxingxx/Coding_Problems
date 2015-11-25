/* Problem: Longest Palindromic Substring*/



/*2nd round, iterative
 *one-pass of each char in s, by using that char as center and move both ways untill the head char and tail char are not the same. 
 *save start index, and maxLen found in that iteration if it's a longer palindrome.
 */
public class Solution {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
        return s;
        
        //one-pass of each char in s, by using that char as center and move both ways untill the head char and tail char are not the same. 
        //record lo, and maxLen found in that iteration if it's a longer palindrome.
        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}

/*1st round, dynamic programming, O(n^2) space, O(n^2)time, too slow for large input*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null)
		    return null;
 
	    if(s.length() <=1)
		    return s;
 
	    int maxLen = 0;
	    String longestStr = null;
 
	    int length = s.length();
 
	    int[][] table = new int[length][length];
 
        //start from len = 1;
	    //every single letter is palindrome
	    for (int i = 0; i < length; i++) {
		    table[i][i] = 1;
	    }
 
        //then len = 2
	    for (int i = 0; i <= length - 2; i++) {
		    if (s.charAt(i) == s.charAt(i + 1)){
			    table[i][i + 1] = 1;
			    longestStr = s.substring(i, i + 2);
		    }	
	    }
	    
	    //then lend = 3 ~ string.length, first check head and tail char, then move to center, untill move to alread-built table cells.
	    //condition for calculate whole table
	    for (int l = 3; l <= length; l++) {
		    for (int i = 0; i <= length-l; i++) {
		    	int j = i + l - 1;
		    	if (s.charAt(i) == s.charAt(j)) {
		       		table[i][j] = table[i + 1][j - 1];
			    	if (table[i][j] == 1 && l > maxLen)
				    	longestStr = s.substring(i, j + 1);
			    } else {
			    	table[i][j] = 0;
			    }
		    }
	    }
 
    	return longestStr;
    }
}

