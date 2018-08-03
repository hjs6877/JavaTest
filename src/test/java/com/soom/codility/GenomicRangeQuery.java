package com.soom.codility;

public class GenomicRangeQuery {
    public static void main(String[] args){
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        int[] result = solution(S, P, Q);

        for(int r : result){
            System.out.println(r);
        }
    }

    private static int[] solution(String S, int[] P, int[] Q) {
        int M = P.length;
        int[] result = new int[M];


        for(int i = 0; i < M; i++){
            int minValue = 5;
            String str = S.substring(P[i], Q[i] + 1);
            for(char c : str.toCharArray()){
                minValue = Math.min(minValue, typeToFactor(c));
            }

            result[i] = minValue;
        }

        return result;
    }

    private static int typeToFactor(char c) {
        switch (c){
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return -1;
        }
    }
}
