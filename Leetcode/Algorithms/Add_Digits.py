#Problem: Add Digits
#Given a non-negative integer num, 
#repeatedly add all its digits until the result has only one digit.

#For example:
#Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
#Since 2 has only one digit, return it.


class Solution:
    # @param {integer} num
    # @return {integer}
    def addDigits(self, num):
        strNum = str(num)
        while len(strNum)>1:
            sum = 0
            for char in strNum:
                sum +=int(char)
            strNum = str(sum)
        return int(strNum)

#2nd round
#A special pattern discovered for this problem:
# 1) if the number is zero, the result is of course zero;
# 2) if the non-negative number can be divided by 9, the add-digit result should be 9;
# 3) if the non-negative number cannot be divided by 9, the add-digit result should be the reminder;

class Solution:
    # @param {integer} num
    # @return {integer}
    def addDigits(self, num):
        if num == 0:
            return 0
        elif num % 9 == 0:
            return 9
        else:
            return num % 9
        
        