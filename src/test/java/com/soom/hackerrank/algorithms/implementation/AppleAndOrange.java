package com.soom.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class AppleAndOrange {
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        // Complete this function
        int appleCount = 0;
        int orangeCount = 0;

        appleCount = calculate(a, apples, s, t);
        orangeCount = calculate(b, oranges, s, t);
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    static int calculate(int tree, int[] fruits, int s, int t){
        int count = 0;
        for(int fruit : fruits){
            if((tree + fruit >= s) && (tree + fruit) <= t){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        countApplesAndOranges(s, t, a, b, apple, orange);
        in.close();
    }
}
