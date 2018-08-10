package com.soom.algorithm.fibonacci;

/**
 * print sum of fibonacci arithmetic sequence of n count
 */
public class FibonacciRecursive2 {
    public static void main(String[] args){
        int n = 6;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += fibo(i);
        }

        System.out.println(sum);
    }

    private static int fibo(int n) {
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        return fibo(n - 2) + fibo(n - 1);
    }

}
