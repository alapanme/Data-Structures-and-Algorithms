package com.alapan.dsalgo.practice;
public class reverseString {

    public String reverseBruteForce(String str) { //o(n) Time complexity
        if (str.isBlank()|| str.length() < 2) {
            return "Invalid input";
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i =str.length()-1 ; i>=0; i--) {
                sb.append(str.charAt(i));
            }
            return (sb.toString());
        }
    }

    public static void main(String[] args){
        reverseString rb = new reverseString();
        System.out.println(rb.reverseBruteForce("My Name is Alapan"));
    }

}
