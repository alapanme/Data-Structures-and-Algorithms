package com.alapan.dsalgo.javabasics;

public class genericMethodPubClass {

    public <T> void showItem (T item){
        System.out.println("The Item is: " + item.toString());
    }

    public <T> T showReturnedItem (T item){
        return item;
    }

    public <K,V> void showKeyValuePair(K key, V value){
        System.out.println("Key is: "+ key.toString());
        System.out.println("Value is: "+ value.toString());
    }

    public <T> void itemArray(T[] items){
//        for(int i=0; i<items.length; i++){
//            System.out.println(items[i]);
//        }

        for(T item: items){
            System.out.println(item);
        }
    }
}
