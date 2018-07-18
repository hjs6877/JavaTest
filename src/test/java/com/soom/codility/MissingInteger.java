package com.soom.codility;

public class MissingInteger {
    public static void main(String[] agrs){
        int[] A = {1, 2, 3, 5, 6, 5};
        int missingNum = solution(A);

        System.out.println(missingNum);
    }

    private static int solution(int[] A) {

        boolean[] B = new boolean[A.length+1];

        for(int j=0; j < A.length; j++){
            if(A[j] > 0 && A[j] < B.length){
                B[A[j]] = true;
            }
        }

        int smallest = 1;
        for(int k = 1; k < B.length; k++){
            if(!B[k]){
                smallest = k;
                break;
            }else{
                smallest = B.length;
            }
        }

        return smallest;
    }
}
