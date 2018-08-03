package com.soom.codility;

public class GenomicRangeQuery75 {
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
        int N = S.length();
        int M = P.length;
        int[] impactFactor = new int[M];

        for (int i = 0; i < M; i ++) {
            String part;
            if (Q[i] + 1 > N) {
                part = S.substring(P[i]);
            } else {
                part = S.substring(P[i], Q[i] + 1);
            }

            if (part.indexOf("A") != -1) {
                impactFactor[i] = 1;
            } else if (part.indexOf("C") != -1) {
                impactFactor[i] = 2;
            } else if (part.indexOf("G") != -1) {
                impactFactor[i] = 3;
            } else {
                impactFactor[i] = 4;
            }
        }

        return impactFactor;
    }
}
