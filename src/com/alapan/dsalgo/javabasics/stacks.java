package com.alapan.dsalgo.javabasics;

import java.util.Stack;

public class stacks {

    public static void main(String args[]){

        Stack<String> names = new Stack<>();

        names.push("Michael");
        names.push("Dwight");
        names.push("Jim");
        names.push("Pam");
        names.push("Kelly");

        System.out.println(names.peek());

        System.out.println(names.size());
        System.out.println(names.pop());
        System.out.println(names.size());

        while(!names.isEmpty()){
            System.out.println(names.pop());
        }
    }
}
