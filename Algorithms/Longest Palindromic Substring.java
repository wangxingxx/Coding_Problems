/* Problem: Longest Palindromic Substring*/

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

