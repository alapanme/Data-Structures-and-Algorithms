package com.alapan.dsalgo.javabasics;

public class genericMethodMain {

    public static void main(String args[]){

        genericMethodPubClass gen = new genericMethodPubClass();
        gen.showItem("Hello World");
        System.out.println("The returned item is: " + gen.showReturnedItem("Bye World"));
        gen.showKeyValuePair("Tree", "Green");
        gen.showKeyValuePair("Number", 007);
        Integer[] Num = {1,2,3,4,5};
        gen.itemArray(Num);
        String[] str ={"Michael", "Dwight", "Jim", "Kevin", "Stanley", "Oscar", "Pam"};
        gen.itemArray(str);
    }
}
