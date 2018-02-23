package com.soom.hackerrank;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2016-12-16 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class AVeryBigSum {
    public static void main(String[] args){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int count = scanner1.nextInt();
        String numbers = scanner2.nextLine();
        String[] numberArray = numbers.split(" ");

        long sum = 0L;
        for(int i=0; i < count; i++){
            sum += Long.parseLong(numberArray[i]);
        }

        System.out.println(sum);
    }
}
