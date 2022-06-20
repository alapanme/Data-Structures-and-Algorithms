//https://leetcode.com/problems/valid-parentheses/
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false
 */
package com.alapan.dsalgo.leetcode;

import java.util.Stack;

public class validParentheses {

    public boolean bruteForce(String s) { //O(n) Time Complexity. O(n) Space Complexity
        if (s.length() % 2 != 0) return false;
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] == '(' || sArray[i] == '{' || sArray[i] == '[') {
                stack.push(sArray[i]);
            } else if (sArray[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (sArray[i] == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (sArray[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(sArray[i]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        validParentheses obj = new validParentheses();
        System.out.println(obj.bruteForce("([}}])"));
        System.out.println(obj.bruteForce("()[]{}"));
    }
}