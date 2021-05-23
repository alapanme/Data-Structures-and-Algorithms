package com.alapan.dsalgo.javabasics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class upperBoundedWildCards {

    public static void showAll(List<? extends Number> list) {
        for(Number n: list){
            System.out.println(n);
        }
    }

    public static void sumAll(List <? extends Number> list) {
        double sum = 0;
        for (Number n: list) {
            sum += n.doubleValue();
        }

        System.out.println(sum);
    }

    public static void main(String args[]) {

        //Creating Array List like this
        List<? extends Number> l1 = new ArrayList<Integer>();
        List<? extends Number> l2 = new ArrayList<Double>();
        List<? extends Number> l3 = new ArrayList<Float>();

        showAll(Arrays.asList(1,2,3));
        sumAll(Arrays.asList(1,2,3));

    }
}
