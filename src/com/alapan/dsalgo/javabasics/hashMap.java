package com.alapan.dsalgo.javabasics;
import java.util.HashMap;
import java.util.Map;

public class hashMap {

    public static void main(String args[]) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Michael");
        map.put(2, "Kevin");
        map.put(3, "Dwight");
        map.put(4, "Pam");
        map.put(5, "Oscar");

        System.out.println(map.get(2));

        map.remove(2);

        for(Integer key: map.keySet()){
            System.out.println(map.get(key));
        }

        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
