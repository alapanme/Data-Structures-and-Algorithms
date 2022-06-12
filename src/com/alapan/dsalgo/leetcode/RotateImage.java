//https://leetcode.com/problems/rotate-image/
//Very well Explained - https://www.youtube.com/watch?v=SA867FvqHrM

package com.alapan.dsalgo.leetcode;
import java.util.Arrays;

/*
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

The idea was firstly transpose the matrix and then flip it symmetrically. For instance,
1  2  3
4  5  6
7  8  9

after transpose, it will be swap(matrix[i][j], matrix[j][i])
1  4  7
2  5  8
3  6  9

Then flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
7  4  1
8  5  2
9  6  3

//Transpose Logic
i=0; j=0
temp = matrix[0][0] //1
matrix[0][0] = matrix[0][0] //1
matrix[0][0] = temp //1

i=0;j=1
temp = matrix[0][1] //2
matrix[0][1] = matrix[1][0] //matrix[1][0] is 4. So 2 and 4 swap
matrix[0][0] = temp //matrix[1][0] is 4. So 2 and 4 swap

i=0; j=2;
temp = matrix[0][2] //3
matrix[0][2] = matrix[2][0] //matrix[2][0] is 7. So 3 and 7 swap
matrix[0][0] = temp //matrix[2][0] is 7. So 3 and 7 swap

i=1; j=1
temp = matrix[1][1] //5
matrix[1][1] = matrix[1][1] //5
matrix[1][1] = temp //5

i=1;j=2
temp = matrix[1][2] //6
matrix[1][2] = matrix[2][1] //matrix[2][1] is 8. So 6 and 8 swap
matrix[1][1] = temp //matrix[2][1] is 8. So 6 and 8 swap

i=2; j=2
temp = matrix[2][2] //9
matrix[2][2] = matrix[2][2] //9
matrix[1][1] = temp //9


//Swap Logic
We are now working on this array:
1  4  7
2  5  8
3  6  9

We will be converting it to this:
7  4  1
8  5  2
9  6  3

i=0; j=0
temp = matrix[0][0] //1
matrix[0][0] = matrix[0][3-1-0] //matrix[0][2] is 7. So swap 1 and 7
matrix[0][3-1-0] = temp //matrix[0][2] is 7. So swap 1 and 7

i=0; j=1
temp = matrix[0][1] //4
matrix[0][1] = matrix[0][3-1-1] //matrix[0][1] = matrix[0][1] //both point to same element, so no swapping
matrix[0][3-1-1] = temp //4

i=1; j=0
temp = matrix[1][1] //2
matrix[1][1] = matrix[1][3-1-0] //matrix[1][2] is 8. So swap 2 and 8
matrix[1][3-1-0] = temp //matrix[1][2] is 8. So swap 2 and 8

i=1; j=1
temp = matrix[1][1] //5
matrix[1][1] = matrix[1][3-1-1] //matrix[1][1] = matrix[1][1] //both point to same element, so no swapping
matrix[1][3-1-1] = temp //5

i=2; j=0
temp = matrix[2][0] //3
matrix[2][0] = matrix[2][3-1-0] //matrix[2][2] is 9. So swap 3 and 9
matrix[2][3-1-0] = temp //matrix[2][2] is 9. So swap 3 and 9

i=2; j=1
temp = matrix[2][1] //6
matrix[2][1] = matrix[2][3-1-1] //matrix[2][1] = matrix[2][1] //both point to same element, so no swapping
matrix[2][3-1-1] = temp //6

 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        /*
        Time complexity : O(M), as each cell is getting read once and written once. M be the number of cells in the matrix.
        Space complexity : O(1) because we do not use any other additional data structures.
        */
        int len = matrix.length;

        //Transpose the matrix with swapping matrix[i][j] with matrix[j][i]
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Flip the matrix horizontally. (swap(matrix[i][j], matrix[i][matrix.length-1-j])
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        RotateImage obj = new RotateImage();
        obj.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        obj.rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
    }
}
