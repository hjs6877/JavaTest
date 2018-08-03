package com.soom.codility;

public class GenomicRangeQuery100 {
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

        int[] result = new int[M];
        // 2차원 배열에 index 증가에 따른 char 별 누적 카운트
        // [0] = A, [1] = C, [2] = G, [3] = T
        int[][] accumulation = new int[4][N + 1];

        for (int i = 0; i < N; i ++) {
            // 문자를 찾으면 누적 카운트 ++
            switch (S.charAt(i)) {
                case 'A': accumulation[0][i + 1]++; break;
                case 'C': accumulation[1][i + 1]++; break;
                case 'G': accumulation[2][i + 1]++; break;
                case 'T': accumulation[3][i + 1]++; break;
            }

            // 마지막 반복 제외
            if (i < N - 1) {
                // 현재 index 까지의 누적 카운트를 다음 index에도 누적
                for (int j = 0; j < 4; j++) {
                    accumulation[j][i + 2] = accumulation[j][i + 1];
                }
            }
        }


        for (int i = 0; i < M; i ++) {
            int start = P[i];
            int end = Q[i];

            for (int j = 0; j < 4; j++) {
                // 끝 지점과 시작 지점의 누적 카운트가 다르다면 (= 해당 문자가 있다면)
                if (accumulation[j][start] != accumulation[j][end + 1]) {
                    // 발견시 최소값에 삽입
                    result[i] = j + 1;
                    // 최소 factor 부터 확인하므로, 발견시 이후 factor는 확인할 필요 없음
                    break;
                }
            }
        }

        return result;
    }
}
