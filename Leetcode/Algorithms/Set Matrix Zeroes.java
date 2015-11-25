/* Problem: Set Matrix Zeroes
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
 * Follow up:
 * 1. solve it use O(m+n) space intead of O(mn) space.
 * 2. solve it with constant space.
 */

/*1st round, naive alg, using extra O(mn) space to keep track if that element is visited, run time O(mn)*/
public class Solution {
    public void setZeroes(int[][] matrix) {        
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



/*2nd round, using two arrays, O(m+n) extra space, to keep track the index of rows and columns that contain zeros, then update those rows and columns with zeros, runing time O(mn)*/
public class Solution {
    public void setZeroes(int[][] matrix) { 
        //Corner cases:
        if (matrix == null || matrix.length == 0) return;
        
        //General cases:
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMkr = new int[m];
        int[] colMkr = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowMkr[i] = 1;
                    colMkr[j] = 1;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (rowMkr[i] == 1) {
                for (int t = 0; t < n; t++) {
                    matrix[i][t] = 0;
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (colMkr[j]  == 1) {
                for (int s = 0; s < m; s ++) {
                    matrix[s][j] = 0;
                }
            }
        }
    }
}



/*3rd round, using the first row and first colomn of given matrix instead of extra arrays, improved space complexity to O(1)*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        // ALG:
        // Use the first element of each row and each column to store its state (if contains zeros).
        // Then scan backwards from [m-1][n-1] to [1][1], 
        //      if the states show either this row contains zero or this column contains zero, the current element will be set to zero.
        // This will also includes the affect that the only zeros are just in the first row and first column.
        
        // Corner cases:
        if (matrix == null || matrix.length == 0) return;
        
        // General cases:
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1; 
        // Becaue the first element of the first row and first column will both be matrix[0][0], use an extra variable to store the state of the first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0; // Scan the first column. If there exists zeros, col0 = 0.
            }
            for (int j = 1; j < n; j++) { // Scan the rest columns. If there exists zeros, the first elements of that column and that row are set to zero.
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Since the first row and first column are used to be indicators, it's better to scan backwards.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }       
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}
