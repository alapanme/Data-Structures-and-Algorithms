//Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards
//in your hands. The array is virtually split into a sorted and an unsorted part.
//Values from the unsorted part are picked and placed at the correct position in the sorted part.
//Time Complexity is 0(n²)

package com.alapan.dsalgo.sort;

public class insertionSort {

    public static void main(String args[]) {
        int[] array = {15, 20, -10, 35, 60, 190, -34};

        for (int unsortedIndex = 1; unsortedIndex < array.length; unsortedIndex++) {
            int newElement = array[unsortedIndex];
            int i;
            for (i = unsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }

        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
}
