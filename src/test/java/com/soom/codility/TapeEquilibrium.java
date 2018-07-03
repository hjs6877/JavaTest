package com.soom.codility;

public class TapeEquilibrium {
    public static void main(String[] args){
        int[] N = {3, 1, 2, 4, 3};


        int n = solution(N);

        System.out.println(n);
    }

    private static int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;

        for(int i = 0; i < A.length; i++){
            right += A[i];
        }

        for(int i = 1; i < A.length; i++){
            left += A[i - 1];
            right -= A[i - 1];

            min = Math.min(min, Math.abs(left - right));
        }

        return min;
    }
}
