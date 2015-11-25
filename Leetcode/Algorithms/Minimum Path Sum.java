/* Problem: Minimum Path Sum 
 * Given a m x n grid filled with non-negative numbers, 
 * find a path from top left to bottom right 
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */


public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        if(m==1){
            int sum=0;
            for(int num:grid[0])
            sum+=num;
            return sum;
        }
        //assistant table initialization
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        dp[0][1] = dp[0][0]+grid[0][1];
        dp[1][0] = dp[0][0]+grid[1][0];
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        
        //dynamic programming
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[m-1][n-1];
    }
    
}