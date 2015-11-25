/* Problem: Spiral Matrix II
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 *  [
 *    [ 1, 2, 3 ],
 *    [ 8, 9, 4 ],
 *    [ 7, 6, 5 ]
 *   ]
 */




public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mx = new int[n][n];
        if (n == 0) {
            return mx;
        }
        if (n == 1) {
            mx[0][0] = 1;
            return mx;
        }
        
        int curNum = 1;
        int layer = 0;
        
        while(layer <= n/2 && curNum <= n*n){
            for (int i = 0 + layer; i < n - layer; i ++) {
                mx[layer][i] = curNum;
                curNum ++;
            }
        
            for (int i = 1 + layer; i < n - layer; i ++) {
                mx[i][n-1-layer] = curNum;
                curNum ++;
            }
        
            for (int i = n - 2 - layer; i >= 0 + layer; i --) {
                mx[n-1-layer][i] = curNum;
                curNum ++;
            }
        
            for (int i = n - 2 - layer; i >= 1 + layer; i --) {
                mx[i][layer] = curNum;
                curNum ++;
            }
            layer ++;
        }
        return mx;
    }
}