//https://leetcode.com/problems/compare-version-numbers/

/*Version numbers consist of one or more revisions joined by a dot '.'.
Each revision consists of digits and may contain leading zeros.
Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0,
the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order.
Revisions are compared using their integer value ignoring any leading zeros.
This means that revisions 1 and 001 are considered equal.
If a version number does not specify a revision at an index, then treat the revision as 0.
For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.

Example 1:
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".

Example 2:
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".

Example 3:
Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
 */

package com.alapan.dsalgo.leetcode;

public class compareVersionNumbers {

    public int compareVersion(String version1, String version2) { //Time Complexity is O(M+N). Space Complexity is O(M+N)
/*Algorithm
Split both strings by dot character into two arrays.
1. Iterate over the longest array and compare chunks one by one.
2. If one of the arrays is over, virtually add as many zeros as needed to continue the comparison with the longer array.
3. If two chunks are not equal, return 1 or -1. If we're here, the versions are equal. Return 0.
*/

        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int maxLength = Math.max(len1, len2);
        int v1, v2;
        for (int i = 0; i < maxLength; i++) {
            if (i < len1) {
                v1 = Integer.parseInt(s1[i]);
            } else {
                v1 = 0;
            }
            if (i < len2) {
                v2 = Integer.parseInt(s2[i]);
            } else {
                v2 = 0;
            }
            if (v1 != v2) {
                if (v1 > v2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0; //v1 and v2 are equal
    }

    public static void main(String[] args) {
        compareVersionNumbers obj = new compareVersionNumbers();
        System.out.println(obj.compareVersion("1.01", "1.001"));
        System.out.println(obj.compareVersion("0.1", "1.1"));
    }
}
