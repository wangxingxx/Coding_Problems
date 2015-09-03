/* Problem: Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
 * /


public class Solution {
    public void setZeroes(int[][] matrix) {
        //Scan starting from [0][0] to [m-1][n-1]
        //Ever meets a zero at [i][j], set matrix[i][0..n-1] and matrix[0..m-1][j] to zeros
        //     and move to [i+1][0], skip other elements in the same row.
        
        //Corner cases:
        if (matrix == null || matrix.length == 0) return;
        
        //General cases:
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] marker = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marker[i][j] == 1) {
                    continue;
                }
                else if (matrix[i][j] == 0) {
                    for (int t = 0; t < n; t++) {
                        if (matrix[i][t] != 0) {
                            matrix[i][t] = 0;
                            marker[i][t] = 1;
                        }
                        
                    }
                    for (int s = 0; s < m; s++) {
                        if (matrix[s][j] != 0) {
                            matrix[s][j] = 0;
                            marker[s][j] = 1;
                        }
                    }
                }
            }
        }
    }
}
