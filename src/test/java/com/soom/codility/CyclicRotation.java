package com.soom.codility;

public class CyclicRotation {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        int k = 8;

        rotate(a, k);
    }

    private static void rotate(int[] A, int K) {
        int[] rotatedArr = new int[A.length];

        for(int i = 0; i < A.length; i++){
            int idx;
            int realMoveCount = K % A.length;
            int lastIdx = A.length - 1;

            if(i + realMoveCount <= lastIdx){
                idx = i + realMoveCount;
            }else{
                idx = realMoveCount - (lastIdx - i) - 1;
            }

            rotatedArr[idx] = A[i];
        }
    }
}
