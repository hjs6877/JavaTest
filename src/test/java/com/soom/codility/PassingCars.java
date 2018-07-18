package com.soom.codility;

public class PassingCars {
    public static void main(String[] args){
        int[] A = {0, 1, 0, 1, 1};
        int passings = solution(A);

        System.out.println(passings);
    }

    private static int solution(int[] A) {
        int Q = 0;
        int passings = 0;

        for(int num : A){
            Q += num;
        }

        for(int num : A){
            Q -= num;
            if(num == 0){
                passings += Q;
            }

            if(passings > 1000000000){
                return -1;
            }
        }
        return passings;
    }
}
