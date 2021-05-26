package com.alapan.dsalgo.javabasics;

import java.util.LinkedList;

public class linkedLists {

    public static void main(String args[]) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.addFirst(4);
        list.addFirst(5);
        list.addFirst(6);

        list.addLast(7);
        list.addLast(8);
        list.addLast(9);

        list.removeFirst();
        list.removeLast();

        System.out.println("Size is: "+ list.size());
        System.out.println("Is List empty: "+ list.isEmpty());
        for(Integer n: list) {
            System.out.println(n);
        }
    }
}
