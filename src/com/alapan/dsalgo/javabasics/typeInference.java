package com.alapan.dsalgo.javabasics;
import java.util.ArrayList;
import java.util.List;

class Bucket<T> {

    private T item;

    public T getItem() {
        return this.item;
    }

    public void setItem(T item){
        this.item = item;
    }

}

public class typeInference {

    public static <T> void addStore(T t, List<Bucket<T>> list){
        Bucket<T> bucket = new Bucket<>();
        bucket.setItem(t);
        list.add(bucket);
        System.out.println(t.toString() + " has been added to the list..");
    }

    public static <T> List<T> add (List<T> list, T item1, T item2){
        list.add(item1);
        list.add(item2);
        return list;
    }

    public static void main(String args[]){
        List <Bucket<String>> list = new ArrayList<>();
        addStore("Adam", list);
        List <Integer> list1 = add(new ArrayList<>(), 20, 30);
        System.out.println(list1);
        List <String> list2 = add(new ArrayList<>(), "Hello", "World");
        System.out.println(list2);
    }

}
