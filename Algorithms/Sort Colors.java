/* Problem: Sort Colors
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.

/*1st round, two passes, constant space*/
public class Solution {
    public void sortColors(int[] nums) {
		if (nums == null)
			return;
		if (nums.length < 2)
			return;
		int zero = 0;
		int one = 0;
		int two = 0;
		for (int num : nums) {
			switch (num) {
			case 0:
				zero++;
				continue;
			case 1:
				one++;
				continue;
			case 2:
				two++;
				continue;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < zero)
				nums[i] = 0;
			else if (i >= nums.length - two)
				nums[i] = 2;
			else
				nums[i] = 1;
		}
	}
}