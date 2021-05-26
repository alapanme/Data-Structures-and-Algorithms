package com.alapan.dsalgo.javabasics;

import java.util.ArrayList;
import java.util.LinkedList;

public class arrayListLinkedListPerformance {

    public static void main(String args[]) {

        ArrayList<Integer> list1 = new ArrayList<>();
        long now = System.currentTimeMillis();
        for (int i = 0; i <= 50000; i++) {
            //list1.add(0, i);
            list1.add(i);
        }
        System.out.println("Time taken by ArrayList in milliseconds: " + (System.currentTimeMillis() - now));

        LinkedList<Integer> list2 = new LinkedList<>();
        now = System.currentTimeMillis();
        for (int i = 0; i <= 50000; i++) {
            //list2.addFirst(i);
            list2.addLast(i);
        }
        System.out.println("Time taken by LinkedList in milliseconds: " + (System.currentTimeMillis() - now));
    }
}
