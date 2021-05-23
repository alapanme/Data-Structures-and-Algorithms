//task is to implement copy method (it is present in Collections by the way) that's able to
// copy the items from a source list into a destination list.
// Use wildcards with the appropriate bounds!

//Read from list upper bounded wild cards (extends)
//Write into the list lower bounded wild cards(super)
package com.alapan.dsalgo.javabasics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class upperLowerBoundedParams {

    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        for (int i = 0; i < source.size(); i++) {
            destination.add(source.get(i));
        }
    }

    public static void main(String args[]){
        List<String> l1 = Arrays.asList("Pam", "Dwight", "Michael");
        List<String> l2 = new ArrayList<>();
        copy(l1, l2);
        System.out.println(l2);
        }
}
