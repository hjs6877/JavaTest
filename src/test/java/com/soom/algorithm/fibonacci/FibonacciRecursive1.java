package com.soom.algorithm.fibonacci;

/**
 * print fibonacci arithmetic sequence of n count
 */
public class FibonacciRecursive1 {
    public static void main(String[] args){
        int n = 6;

        for(int i = 0; i < n; i++){
            System.out.println(fibo(i));
        }
    }

    private static int fibo(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibo(n - 2) + fibo(n - 1);
    }
}
