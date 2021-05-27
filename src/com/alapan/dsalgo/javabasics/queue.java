package com.alapan.dsalgo.javabasics;

import java.util.LinkedList;
import java.util.Queue;

public class queue {

    public static void main(String args[]){

        Queue<String> names = new LinkedList<>();

        names.offer("Michael");
        names.offer("Dwight");
        names.offer("Jim");
        names.offer("Pam");
        names.offer("Kelly");

        names.add("Oscar");
        names.add("Hank");

        System.out.println("Removed Item is: " + names.remove());

        while(!names.isEmpty()){
            System.out.println(names.remove());
        }

    }
}
