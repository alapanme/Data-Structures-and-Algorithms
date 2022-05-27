//https://leetcode.com/problems/integer-to-roman/solution/

/*
M - 1000
CM - 900
D - 500
CD - 400
C - 100
XC - 90
L - 50
XL - 40
X - 10
IX - 9
V - 5
IV - 4
I - 1

As explained in the overview, the representation should use the largest possible symbols, working from the left.
Therefore, it makes sense to use a Greedy algorithm.
A Greedy algorithm is an algorithm that makes the best possible decision at the current time; in this case taking out the largest possible symbol it can.

So to represent a given integer, we look for the largest symbol that fits into it.
We subtract that, and then look for the largest symbol that fits into the remainder, and so on until the remainder is 0.
Each of the symbols we take out are appended onto the output Roman Numeral string.

For example, suppose we need to make the number 671.

The largest symbol that fits into 671 is D (which is worth 500).
The next symbol up, CM, is worth 900 and so is too big to fit. Therefore, we now have the following.

Roman Numeral so far: D
Integer remainder: 671 - 500 = 171
We now repeat the process with 171. The largest symbol that fits into it is C (worth 100).

Roman Numeral so far: DC
Integer remainder: 171 - 100 = 71
Repeating this with 71, we find the largest symbol that fits in is L (worth 50).

Roman Numeral so far: DCL
Integer remainder: 71 - 50 = 21
For 21, the largest symbol that fits in is X (worth 10).

Roman Numeral so far: DCLX
Integer remainder: 21 - 10 = 11
For 11, the largest symbol that fits in is again X.

Roman Numeral so far: DCLXX
Integer remainder: 11 - 10 = 1
Finally, the 1 is represented with a I and we're done.

Roman Numeral so far: DCLXXI
Integer remainder: 1 - 1 = 0
 */

package com.alapan.dsalgo.leetcode;

public class integerToRoman {   //Time complexity: O(1). Space Complexity: O(1)

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length & num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num = num - values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        integerToRoman obj = new integerToRoman();
        System.out.println(obj.intToRoman(671));
    }
}
