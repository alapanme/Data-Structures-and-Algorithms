package com.alapan.dsalgo.javabasics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class lowerBoundedWildCards {

    public static void showAll(List<? super Number> list) {
        for(Object n: list){
            System.out.println(n);
        }
    }

    public static void main(String args[]){

        //Creating Array List like this
        List<? super Integer> l1 = new ArrayList<Integer>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();

        //Read items using lower bound wild card
        List<Serializable> list = new ArrayList<>();
        list.add("Creed");
        list.add("Kevin");
        list.add("Pam");
        showAll(list);

        //Insert Items
        List<? super Number> numList = new ArrayList<>();
        list.add(3);
        list.add(5);
    }
}
