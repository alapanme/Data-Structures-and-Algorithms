package com.alapan.dsalgo.javabasics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wildCards {

    public static void print(List<?> list){
        for (Object o: list){
            System.out.println(o);
        }
    }

    public static <T extends Shape> void drawAll(List<T> shapes) {
        for(T shape: shapes) {
            shape.draw();
        }
    }

    public static void main(String args[]){
        List<Integer> num = Arrays.asList(1 ,2 ,3);
        List<String> str = Arrays.asList("Michael", "Dwight", "Jim", "Pam");
        print(num);
        print(str);

        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle());
        drawAll(rectangles);
    }
}