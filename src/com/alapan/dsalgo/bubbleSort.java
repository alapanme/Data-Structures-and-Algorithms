//Compare each element with the last element, and swap the elements so that the largest one is the last.
//And then after one loop, compare elements with the element before, swap sp that the element,
//before last has the next largest.
//Time Complexity is 0(n²)

package com.alapan.dsalgo;

public class bubbleSort {

    public static void main(String[] args) {

        int[] array = {10, 2, -89, 333, 101, 994, 2987987, -9000, 784, 10003};
        int temp = 0;

        for (int last = array.length - 1; last > 0; last--) {
            for (int first = 0; first <= last - 1; first++) {

                if (first == last) {
                    return; //Check if the array only has one element
                } else if (array[first] > array[last]) {
                    temp = array[first];
                    array[first] = array[last];
                    array[last] = temp;
                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.println(array[k]);
        }
    }
}
