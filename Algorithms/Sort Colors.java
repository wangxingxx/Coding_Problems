/* Problem: Sort Colors
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.


/*3rd round, one-pass, in-place*/
public class Solution {
    public void sortColors(int[] nums) {
        //corner case
        //empty and single elment nums
        //if (n < 2) return;
        
        //general case:
        int front = 0, back = nums.length - 1;
        for (int i = 0; i <= back;) {
            if (front >= back) break;
            
            if (nums[i] == 0) {
                nums[i] = nums[front];
                nums[front] = 0;
                front++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[back];
                nums[back] = 2;
                back--;
                continue;
            }
            i++;
        }
    }
}
/*2nd round, one-pass, constant space*/
public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null) return;
        
        int n = nums.length;
        if(n<2) return;

        int zero = 0;
        int two = n-1;
        int i=0;
        while(i<two+1) {
            if(nums[i]==0 && zero<i){
                nums[i]=nums[zero];
                nums[zero]=0;
                zero++;
                continue;
            }
            if(nums[i]==2 && two > i) {
                nums[i]=nums[two];
                nums[two]=2;
                two--;
                continue;
            }
            i++;
        }
    }
}

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