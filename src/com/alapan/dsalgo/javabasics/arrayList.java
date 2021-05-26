package com.alapan.dsalgo.javabasics;

import java.util.ArrayList;
import java.util.List;

public class arrayList {

    public static void main(String args[]){

        List<String>name = new ArrayList<>();
        name.add("Kevin");
        name.add("Adam");
        name.add("Ana");
        name.add("David");

        System.out.println(name.get(0));

        name.add(3,"Dwight");
        System.out.println("The Array contains Dwight: " + name.contains("Dwight"));
        name.remove(3);
        System.out.println("The Array contains Dwight: " + name.contains("Dwight"));

        for(String s: name){
            System.out.println(s);
        }

       Object[] o = name.toArray();
        for(Object n: o){
            System.out.println(n);
        }
    }
}
