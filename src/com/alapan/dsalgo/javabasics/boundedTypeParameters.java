package com.alapan.dsalgo.javabasics;

public class boundedTypeParameters {

    public static <T extends Number> double addTwoNumbers (T num1, T num2) {
        double result = num1.doubleValue() + num2.doubleValue();
        return result;
    }

    public static <T extends Comparable<T>> T minOfTwoNum(T num1,T num2) {
        if(num1.compareTo(num2) < 0) {//num1 is smaller than num2
            return num1;
        }
        else {
            return num2;
        }
    }

    public static void main(String args[]) {
        System.out.println(addTwoNumbers(5.6,6.2));
        System.out.println(minOfTwoNum(18,07));
        System.out.println(minOfTwoNum("Kevin","Adam"));
    }
}
