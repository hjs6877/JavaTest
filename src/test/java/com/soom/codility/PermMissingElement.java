package com.soom.codility;

public class PermMissingElement {
    public static void main(String[] args){
        int[] N = {2, 3, 1, 5, 4, 7, 9, 8, 10, 11};


        int n = solution(N);

        System.out.println(n);
    }

    private static int solution(int[] A) {
        boolean[] exists = new boolean[A.length + 2];

        for(int i=0; i < A.length; i++){
            int existNum = A[i];
            exists[existNum] = true;
        }

        for(int i=1; i < exists.length; i++){
            if(!exists[i]){
                return i;
            }
        }
        return 0;
    }
}
