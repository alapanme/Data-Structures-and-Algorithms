package com.alapan.dsalgo.javabasics.priorityQueues;

import java.util.PriorityQueue;
import java.util.Queue;

public class App {

    public static void main (String args[]){

        Queue<Person> queue = new PriorityQueue<>();

        queue.add(new Person("Kevin", 36));
        queue.add(new Person("Adam", 26));
        queue.add(new Person("Dwight", 46));
        queue.add(new Person("Michael", 56));
        queue.add(new Person("Pam", 16));

        while(queue.peek() != null){
            System.out.println(queue.poll());
        }

    }
}
