package com.soom.algorithm.fibonacci;

/**
 * print fibonacci arithmetic sequence of n count
 */
public class Fibonacci2 {
    public static void main(String[] args){
        int n = 9;
        int p1 = 0;
        int p2 = 1;
        int count = 1;

        while(count <= n){
            int temp = p1;
            p1 = p2;
            p2 = temp + p2;
            System.out.println(p2);
            count++;
        }
    }
}
