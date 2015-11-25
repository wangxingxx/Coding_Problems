/* Problem: Integer to Roman 
 * Given an integer, convert it to a roman numeral. 
 * Input is guaranteed to be within the range from 1 to 3999.
 */


public class Solution {
    public static String intToRoman(int num) {
		int numM = num / 1000;
		int numC = (num - numM * 1000) / 100;
		int numX = (num - numM * 1000 - numC * 100) / 10;
		int numI = num - numM * 1000 - numC * 100 - numX * 10;

		StringBuilder rst = new StringBuilder();
		while (numM > 0) {
			rst.append('M');
			numM--;
		}
		while(numC>0){
			if (numC == 9) {
				rst.append("CM");
				numC -= 9;
				continue;
			}
			if (numC >= 5) {
				rst.append("D");
				numC -= 5;
				continue;
			}
			if (numC == 4) {
				rst.append("CD");
				numC -= 4;
				continue;
			}
			rst.append('C');
			numC--;
			
		}
		
		while(numX>0){
			if (numX == 9) {
				rst.append("XC");
				numX -= 9;
				continue;
			}
			if (numX >= 5) {
				rst.append("L");
				numX -= 5;
				continue;
			}
			if (numX == 4) {
				rst.append("XL");
				numX -= 4;
				continue;
			}
			rst.append('X');
			numX--;	
		}
		
		while(numI>0){
			if (numI == 9) {
				rst.append("IX");
				numI -= 9;
				continue;
			}
			if (numI >= 5) {
				rst.append("V");
				numI -= 5;
				continue;
			}
			if (numI == 4) {
				rst.append("IV");
				numI -= 4;
				continue;
			}
			rst.append('I');
			numI--;	
		}

		return rst.toString();
	}
    
}