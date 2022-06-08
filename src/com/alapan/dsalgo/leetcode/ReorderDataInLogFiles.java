//https://leetcode.com/problems/reorder-data-in-log-files/
//Good Explanation - https://www.youtube.com/watch?v=Nj2Bpw1KKds

/*You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.

Reorder these logs so that:

1) The letter-logs come before all digit-logs.
2) The letter-logs are sorted lexicographically by their contents.
3) If their contents are the same, then sort them lexicographically by their identifiers.
4) The digit-logs maintain their relative ordering.
Return the final order of the logs.

Example 1:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

Example 2:
Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
*/

/*
3 Different cases for solution to this problem

1a. 2 Letter Logs - "let3 art zero" || "let2 own kit dog"; here "let3 art zero" will come first because 'art zero' comes lexicographically first
1b. "let3 leet code" || "let2 leet code"; here "let2 leet code" will come first because since the main content is same, we compare the id's
lexicographically

2. 1 letter log + 1 digit log - "let3 leet code" || "let2 4 3 1 9"; here "let3 leet code" will come first because letter
logs come before digit logs

3. 2 digit logs - "let3 8 3 5" (index=4)|| "let2 4 3 1" (index=2); here "let2 4 3 1" will come first as its index is lesser than 4.

Next, we have to divide the string into id and log. For eq. "let3 art zero" will have:
id = let3
log = art zero

Next, we have to identify that whether the log is letter log or a digit log. So check the first character. eg.
"let3 leet code", the first letter of the log is 'l', it's a letter log
"let2 4 3 1 9", the first letter of the log is '4', it's a digit log
 */
package com.alapan.dsalgo.leetcode;

import java.util.Arrays;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            //log1 < log2 -> -1
            //log1 = log2 -> 0
            //log1 > log2 -> 1
            int index1 = log1.indexOf(" ");
            String id1 = log1.substring(0, index1);
            String main1 = log1.substring(index1 + 1);

            int index2 = log2.indexOf(" ");
            String id2 = log2.substring(0, index2);
            String main2 = log2.substring(index2 + 1);

            boolean isDigit1 = Character.isDigit(main1.charAt(0));
            boolean isDigit2 = Character.isDigit(main2.charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                int value = main1.compareTo(main2);
                if (value == 0) { //If logs(main1 and main2) are same compare the id's
                    return id1.compareTo(id2);
                } else {
                    return value; //logs(main1 and main2) are equal, hence returning the same
                }
            }

            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2) {
                // the letter-log comes before digit-logs
                return -1;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            } else {
                // case 3). both logs are digit-log
                return 0;
            }

        });
        return logs;
    }

    public static void main(String[] args) {
        ReorderDataInLogFiles obj = new ReorderDataInLogFiles();
        System.out.println(Arrays.toString(obj.reorderLogFiles(
                new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        System.out.println(Arrays.toString(obj.reorderLogFiles(
                new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
    }
}
