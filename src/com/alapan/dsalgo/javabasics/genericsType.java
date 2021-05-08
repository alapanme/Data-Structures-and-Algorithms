package com.alapan.dsalgo.javabasics;

class Store<T> {

    private T item;

    public void setItem(T item){
        this.item = item;
    }

    public T getItem () {
        return this.item;
    }
}

class HashTable<K,V>{

    private K key;
    private V value;

    public HashTable(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class genericsType {

    public static void main(String args[]) {

//        Store<Integer> store = new Store<>();
//        store.setItem(45);
//        Integer item = store.getItem();

//        Store<String> store = new Store<>();
//        store.setItem("Hello World");
//        String item = store.getItem();

        Store<Double> store = new Store<>();
        store.setItem(45.450009);
        Double item = store.getItem();
        System.out.println(item);

//        HashTable<String, Integer> table = new HashTable<>("Hello", 23);

        HashTable<String, String> table = new HashTable<>("Hello", "String");
        System.out.println(table);
    }
}
