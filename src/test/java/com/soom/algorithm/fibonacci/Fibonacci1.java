package com.soom.algorithm.fibonacci;

/**
 * print fibonacci arithmetic sequence less than N
 */
public class Fibonacci1 {
    public static void main(String[] args){
        int n = 60;

        int p1 = 0;
        int p2 = 1;
        int temp;

        System.out.println(p1);
        System.out.println(p2);
        while(true){
            temp = p1;
            p1 = p2;
            p2 = temp + p2;

            if(p2 <= n)
                System.out.println(p2);
            else break;
        }
    }
}
