package com.soom.hackerrank;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2016-12-20 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class TwoDArrays {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[2][6];
        for(int i=0; i < 2; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
    }
}
