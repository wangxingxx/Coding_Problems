/* Problem: Unique Paths
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] helper = new int[m][n];
        for(int i=0;i<m;i++){
            helper[i][0]=1;
        }
        for(int i=0;i<n;i++){
            helper[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                helper[i][j]=helper[i-1][j]+helper[i][j-1];
            }
        }
        return helper[m-1][n-1];
    }
}