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
        