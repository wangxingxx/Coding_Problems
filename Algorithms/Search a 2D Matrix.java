/* Problem: Search a 2D Matrix
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true. 
 */


public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // search the 1st element of each row, 
        // if it's smaller than target:
        //    check the last element of that row, if it's larger than target: 
        //            search in this row using binary search:
        //                   if found, return true;
        //                   otherwise continue to the next row.
        //            otherwise continue to the next row.
        // if it's larger than target: continue to the next row.
        // if it's the same return true;
        // if reaching finishing search all the row, return false;
        
        // corner cases:
        
        // general cases:
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == target) return true;
            else if (matrix[i][0] < target) {
                if (matrix[i][n-1] >= target) {
                    if (binarySearch(target, matrix[i], 0, n) == true) {
                        return true;
                    }
                    else continue;
                }
            }
            else continue;
        }
        
        return false;
    }
    
    public boolean binarySearch(int target, int[] row, int start, int end) {
        if (start > end) return false;
        
        int mid = (start + end) / 2;
        if (target ==  row[mid]) {
            return true;
        }
        else if (target > row[mid]) {
            return binarySearch (target, row, mid + 1, end);
        }
        else {
            return binarySearch (target, row, start, mid - 1);
        }
        
    }
}