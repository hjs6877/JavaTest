package com.soom.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-07 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }

        int d1 = 0;
        int d2 = 0;

        for(int row = 0; row < n; row++){
            int colIdx = n - 1;
            for(int col = 0; col < n; col++){
                if(row == col)
                    d1 += a[row][col];

                if(col == colIdx)
                    d2 += a[row][n - row - 1];

                colIdx--;
            }
        }

        int absDiff = Math.abs(d1-d2);
        System.out.println(absDiff);
    }
}
