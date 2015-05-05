/**
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
**/

public class Solution {
    public int minDistance(String word1, String word2) {
		// define dynamic table
		// len[i+1][j+1] represents the min edit distance
		// of substring of word1[0...i] and substring of word2[0...j]
		int[][] dist = new int[word1.length() + 1][word2.length() + 1];
		dist[0][0] = 0;

		// initialize the table
		for (int i = 0; i < word1.length(); i++)
			dist[i + 1][0] = i + 1;
		for (int i = 0; i < word2.length(); i++)
			dist[0][i + 1] = i + 1;

		// dynamic build the table
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
				
					dist[i + 1][j + 1] = dist[i][j];
				} else {
				 
					dist[i + 1][j + 1] = Math.min(dist[i + 1][j] + 1,
							dist[i][j + 1] + 1);
					dist[i + 1][j + 1] = Math.min(dist[i][j] + 1,
							dist[i + 1][j + 1]);
				}
			}
		}
	 
		return dist[word1.length()][word2.length()];

	}
}