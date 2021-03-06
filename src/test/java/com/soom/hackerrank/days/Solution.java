package com.soom.hackerrank.days;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-08-29 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class Solution {
    private static int[] a;
    private static int numberOfSwaps = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(j);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.printf("Array is sorted in %d swaps.\n", numberOfSwaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[n-1]);
    }

    private static void swap(int idx) {
        int temp;
        temp = a[idx];
        a[idx] = a[idx+1];
        a[idx+1] = temp;
    }
}
