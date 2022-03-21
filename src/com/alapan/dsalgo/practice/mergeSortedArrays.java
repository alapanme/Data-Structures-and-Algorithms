package com.alapan.dsalgo.practice;
import java.util.ArrayList;

public class mergeSortedArrays {

    public ArrayList<Integer> mergeArrayBruteForce(ArrayList<Integer> a, ArrayList<Integer> b){ //O(n) time complexity
        if(a.size() == 0 && b.size() == 0) {
            return null;
        }
        else if(a.size() == 0){
            return b;
        }
        else if(b.size() == 0) {
          return a;
        }
        else{
            ArrayList<Integer> c = new ArrayList<>();
            for (int i=0; i<a.size(); i++) {
                c.add(a.get(i));
            }
            for (int j=0; j<b.size(); j++) {
                c.add(b.get(j));
            }
            return c;
        }
    }

    public static void main (String[] args){
        mergeSortedArrays ms = new mergeSortedArrays();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(5);
        b.add(6);
        System.out.println(ms.mergeArrayBruteForce(a,b));
    }
}
