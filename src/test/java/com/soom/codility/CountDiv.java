package com.soom.codility;

public class CountDiv {
    public static void main(String[] args){
        int A = 6;
        int B = 11;
        int K = 2;

        int result = solution(A, B, K);

        System.out.println(result);
    }

    private static int solution(int A, int B, int K) {
        int count = 0;
        // TODO worst case가 O(1)인데 1차적으로 O(N)으로 계산하였다.
        for(int i = A; i <= B; i++){
            if(i % K == 0)
                count++;
        }
        return count;
    }
}
