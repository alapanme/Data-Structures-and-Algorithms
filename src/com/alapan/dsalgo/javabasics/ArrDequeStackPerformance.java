package com.alapan.dsalgo.javabasics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ArrDequeStackPerformance {

    public static void main(String args[]) {

        Deque<Integer> stack = new ArrayDeque<>();
        long now = System.currentTimeMillis();
        for(int i=0; i<500000; i++) {
            stack.push(i);
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        System.out.println("The total time taken with Arraydeque is: " + (System.currentTimeMillis()-now) + "ms");

        Stack<Integer> stack2 = new Stack<>();
        long now2 = System.currentTimeMillis();
        for(int i=0; i<500000; i++){
            stack2.push(i);
        }
        while(!stack.isEmpty()){
            stack2.pop();
        }
        System.out.println("The total time taken with Stacks is: " +(System.currentTimeMillis() - now2) + "ms");

    }
}
