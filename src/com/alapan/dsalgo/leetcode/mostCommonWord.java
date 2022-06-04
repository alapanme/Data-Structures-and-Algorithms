//https://leetcode.com/problems/most-common-word/
/*
Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned.
It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

Example 1:
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case-sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.

Example 2:
Input: paragraph = "a.", banned = []
Output: "a"
 */

package com.alapan.dsalgo.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class mostCommonWord {

    public String bruteForce(String paragraph, String[] banned) {
        /*
        Time Complexity: O(N+M).
        It would take O(N) time to process each stage of the pipeline as we built.
        In addition, we built a set out of the list of banned words, which would take O(M) time.
        Hence, the overall time complexity of the algorithm is O(N+M).

        Space Complexity: O(N+M).
        We built a hashmap to count the frequency of each unique word, whose space would be of O(N).
        Similarly, we built a set out of the banned word list, which would consume additional O(M) space.
        Therefore, the overall space complexity of the algorithm is O(N+M).
         */

        /*
        We can solve the problem by breaking it into a series of sequential tasks.
        Each task functions like a stage in a pipeline, which takes the input from the previous stage and then channels its output to the next stage.

        More specifically, for this problem, we could break it down into the following stages:

        1. We replace all the punctuations with spaces and at the same time convert each letter to its lowercase.
        One could also accomplish this in two stages. Here we merge them together in one stage.

        2. We split the output in the above step into words, with the separator of spaces.

        3. We then iterate through the words to count the appearance of each unique word, excluding the words from the banned list.

        4. With the hashmap of {word->count}, we then walk through all the items to find the word with the highest frequency.
         */

        //Remove all punctuations
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        //Split the sentence on the basis of spaces into an array
        String[] words = normalizedStr.split("\\s+");

        //Create Hashset for banned words
        HashSet<String> bannedWords = new HashSet<>();
        for (int i = 0; i < banned.length; i++) {
            bannedWords.add(banned[i]);
        }

        HashMap<String, Integer> wordsAndCount = new HashMap<>();
        int count = 1;
        for (int i = 0; i < words.length; i++) {
            if (!bannedWords.contains(words[i]) && !wordsAndCount.containsKey(words[i])) {
                wordsAndCount.put(words[i], count);
            } else if (wordsAndCount.containsKey(words[i])) {
                wordsAndCount.put(words[i], wordsAndCount.get(words[i]) + 1);
            }
        }
        return Collections.max(wordsAndCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        mostCommonWord obj = new mostCommonWord();
        System.out.println(obj.bruteForce("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
