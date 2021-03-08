//Consider the first element as the largest and now compare all elements with the largest element.
//If found, change the largest pointer to the newly found number.
//And now swap the largest number with the last number.
//Time Complexity is 0(n²)

package com.alapan.dsalgo.sort;

public class selectionSort {
    public static void main(String args[]) {

        int[] array = {100, -9, -23, -1, 320230, 89, 8484, 2};
        https://dashboardu.herokuapp.com/
        for (int last = array.length - 1; last > 0; last--) {
            int largest = 0;
            for (int first = 1; first <= last; first++) {
                if (array[first] > array[largest]) {
                    largest = first;
                }
                swap(array, largest, last);
            }
        }

        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }

    public static void swap(int array[], int largest, int last) {

        int temp = array[largest];
        array[largest] = array[last];
        array[last] = temp;
    }
}
