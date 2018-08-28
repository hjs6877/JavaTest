package com.soom.judge;

import java.util.Scanner;

/**
 * 숫자의 출현 횟수 출력.
 */
public class Main2577 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int multiply = a * b * c;
        int[] numCount = new int[10];
        String[] nums = Integer.toString(multiply).split("");

        for(String num : nums){
            numCount[Integer.parseInt(num)]++;
        }

        for(int count : numCount){
            System.out.println(count);
        }
    }
}
