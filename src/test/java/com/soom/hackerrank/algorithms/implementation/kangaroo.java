package com.soom.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class kangaroo {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if(v1 < v2)
            return "NO";

        if((x1 < x2) && (v1 > v2)) {
            int xDiff = Math.abs(x1 - x2);
            int vDiff = Math.abs(v1 - v2);
            if(xDiff % vDiff == 0){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
