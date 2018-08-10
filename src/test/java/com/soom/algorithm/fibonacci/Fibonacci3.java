package com.soom.algorithm.fibonacci;

/**
 * print sum of fibonacci arithmetic sequence of n count
 */
public class Fibonacci3 {
    public static void main(String[] args){
        int n = 8;
        int sum = 0;
        int p1 = 0;
        int p2 = 1;

        for(int i = 0; i < n; i++){
            if(i == 0 || i == 1){
                sum += i;
            }else{
                sum += p1 + p2;
                int p1Temp = p1;
                p1 = p2;
                p2 = p1Temp + p2;
            }
        }

        System.out.println(sum);
    }
}
