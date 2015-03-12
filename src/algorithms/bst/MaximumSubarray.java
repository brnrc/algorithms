package algorithms.bst;

import java.util.function.BinaryOperator;

/**
 * Created by Bruno Cardoso on 11/03/2015.
 * Kadane's algorithm
 */
public class MaximumSubarray {
    public static int kadane(int[] a) {
        int max = 0, current_sum = 0;
        int max_start = 0, max_end = 0;

        for (int i = 0; i < a.length; i++) {
            current_sum = current_sum + a[i];
            if (current_sum < 0) {
                max_start = i+1;
                current_sum = 0;
            }

            if (current_sum > max) {
                max = current_sum;
                max_end = i;
            }
        }

        // Print the maximum subarray
//        System.out.print("\n[");
//        for (int i = max_start; i <= max_end; i++) {
//            System.out.print(a[i] + (i == max_end ? "" : ", "));
//        }
//        System.out.print("]");

        return max;
    }

    /**
     * Calculate the max sum of a submatrix on the input {@code matrix} , using Kadane 2D algorithm.
     * @param matrix the input matrix
     * @return max sum
     */
    public static int kadane2D(int[][] matrix){

        // construct temp matrix by summing matrix upper columns
        int[][] temp = constructSumMatrix(matrix, (a, b) -> a + b);

        // create temp2 matrix by subtracting temp upper columns;
        int[][] temp2 = constructSumMatrix(temp, (a, b) -> a - b);

        // Apply Kadane1D for each row of temp
        int max_sum = 0;
        for (int row = 0; row < temp.length; row++) {
            max_sum = Math.max(kadane(temp[row]), max_sum);
            max_sum = Math.max(kadane(temp2[row]), max_sum);
        }

        return max_sum;
    }

    private static int[][] constructSumMatrix(int[][] source, BinaryOperator<Integer> row_operation) {
        // get the number of rows and columns
        int rows = source.length;
        int cols = source[0].length;

        // Allocate memory based on the size of the source matrix
        int[][] temp2 = new int[rows][cols];

        // fix first row
        temp2[0] = source[0];

        // iterate through each row, applying row_operation on adjacent rows.
        for (int row = 1; row < rows; row++)
            for (int col = 0; col < cols; col++)
                temp2[row][col] = row_operation.apply(source[row][col], source[row - 1][col]);

        return temp2;
    }
}
