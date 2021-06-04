package com.alapan.dsalgo.javabasics;

import java.util.LinkedHashMap;
import java.util.Map;

public class linkedHashMap {

    public static void main(String args[]){

        Map <String, Integer> map = new LinkedHashMap<>();

        map.put("aaa", 1);
        map.put("bbb", 2);
        map.put("ccc", 3);
        map.put("ddd", 4);
        map.put("eee", 5);
        map.put("fff", 6);
        map.put("ggg", 7);

        for(String key: map.keySet()){
            System.out.println(key + " - " + map.get(key));
        }

    }
}
