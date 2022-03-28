//https://coderbyte.com/editor/Longest%20Word:Java
package com.alapan.dsalgo.practice;

import java.util.Scanner;

public class longestWordInSentence {

    public static String longestWord(String sen) { //O(n) Time Complexity
        String[] senArray = sen.split("[^a-z^0-9]");
        int longArrayIndex = 0;
        String longWord = "";
        for (int i = 0; i < senArray.length; i++) {
            if (senArray[i].length() > longArrayIndex) {
                longWord = senArray[i];
                longArrayIndex = senArray[i].length();
            }
        }
        return longWord;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(longestWord(s.nextLine()));
    }

}
