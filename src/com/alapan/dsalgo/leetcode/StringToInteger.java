//https://leetcode.com/problems/string-to-integer-atoi/
/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

1. Read in and ignore any leading whitespace.

2. Check if the next character (if not already at the end of the string) is '-' or '+'.
Read this character in if it is either. This determines if the final result is negative or positive respectively.
Assume the result is positive if neither is present.

3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.

4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0.
Change the sign as necessary (from step 2).

5. If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range.
Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 2^31 - 1 should be clamped to 2^31 - 1.

6. Return the integer as the final result.

Note:
Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.


Example 1:
Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-2^31, 2^31 - 1], the final result is 42.

Example 2:
Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-2^31, 2^31 - 1], the final result is -42.

Example 3:
Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-2^31, 2^31 - 1], the final result is 4193.
 */

package com.alapan.dsalgo.leetcode;

public class StringToInteger {
    public int myAtoi(String s) { //Time complexity is O(n). Space complexity is O(1)
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = s.length();
        // Discard all spaces from the beginning of the input string.
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // sign = +1, if it's positive number, otherwise sign = -1.
        if (index < n && s.charAt(index) == '+') {
            index++;
        } else if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
            /*
            Integer.MAX_VALUE or 2^31 = 2147483647
            Integer.MIN_VALUE or -2^31-1 = -2147483648

            If the current number is equal to 214748364:
            If the next digit is between 0-7, the result will always be in range.
            If, next digit is 8:
            and the sign is '+' the result will overflow, so return INT_MAX;
            if the sign is '-', the result will not underflow but will still be equal to INT_MIN, so that we can return INT_MIN.

            But if, the next digit is greater than 8:
            and the sign is '+' the result will overflow, so return INT_MAX;
            if the sign is '-', the result will underflow, so return INT_MIN.

            Note: We do not need to handle 0-7 for positive and 0-8 for negative integers separately.
            If the sign is negative and the current number is 214748364, then appending the digit 8,
            which is more than 7, will also lead to the same result, i.e., INT_MIN.

            digit > Integer.MAX_VALUE % 10 - checks that the last digit is greater than 7 as 2147483647 % 10 = 7
             */

        // Traverse next digits of input and stop if it is not a digit
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = Integer.parseInt(String.valueOf(s.charAt(index)));

            // Check overflow and underflow conditions.
            if ((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            // Append current digit to the result.
            result = 10 * result + digit; //457 | 10*0+4 = 4 | 10*4+5 = 45 | 10*45+7 = 457
            index++;
        }

        // We have formed a valid number without any overflow/underflow.
        // Return it after multiplying it with its sign.
        return sign * result;
    }

    public static void main(String[] args) {
        StringToInteger obj = new StringToInteger();
        System.out.println(obj.myAtoi("  42"));
        System.out.println(obj.myAtoi("   -42"));
        System.out.println(obj.myAtoi("4193 with words"));
    }
}
