/* Problem: Container With Most Water 
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * Note: You may not slant the container.
 */


/*3rd round, O(n) using two pointers, choose to move with condition*/
public class Solution {
    public int maxArea(int[] height) {
        //alg: two pointers from two ends move towards center.
        
        int rst = 0;//naturally handle the corner case of n < 2;

        //general case:
        int l = 0, r = height.length-1;
        while (l < r) {
            rst = Math.max(rst, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            }else r--;
        }
        
        return rst;
    }
}


/*2nd, more concise code, but still too slow, O(n^2)*/
public class Solution {
    public int maxArea(int[] height) {
        //alg: two pointers from two ends move towards center.
        
        int n = height.length;
        int rst = 0;
        //corner case
        if (n < 2) {
            return rst;
        }
        if (n == 2) {
            rst = Math.min(height[0], height[1]);
            return rst;
        }
        
        //general case:
        for (int i = 0; i < n - 2; i ++) {
            for (int j = n - 1; j > i; j--) {
                int curr = Math.min (height[i], height[j]) * (j - i);
                rst = Math.max(rst, curr);
            }
        }
        
        return rst;
    }
}

/*1st round. Works for small input but too expensive for large data*/
public class Solution {
    public int maxArea(int[] height) {
        //Corner cases:
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        if (n == 1) return 0;
        
        //General cases:
        int[] lineMax = new int[n];
        // For each line i, the max area it can form is determined by the right most line that higher than itself
        // and computed as such (the distance of their indice) * the height of current line i.
        
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j > i; j--) {
                if (height[i] <= height[j]) {
                    lineMax[i] = (j - i) * height[i];
                    break;
                }
            }
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (height[i] <= height[j]) {
                    lineMax[i] = Math.max((i - j) * height[i],lineMax[i]);
                    break;
                }
            }
        }        
        
        int rst = 0;
        for (int area : lineMax) {
            if (rst < area) {
                rst = area;
            }
        }
        
        return rst;
        
    }
}

/*2nd round, improved time complexity to O(n)*/
public class Solution {
    public int maxArea(int[] height) {
        //Corner cases:
        if (height == null || height.length < 2) return 0;

        //General cases:
        int n = height.length;
        int left = 0;
        int right = n-1;
        int rst = 0;
        while(left<right) {
            rst = Math.max(rst, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left ++;
            }
            else {
                right --;
            }
        }
        
        return rst;
        
    }
}