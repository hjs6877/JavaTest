package com.soom.codility;

import java.util.ArrayList;
import java.util.List;

public class MinAvgTwoSlice {
    public static void main(String[] args){
        int[] A = {4, 2, 2, 5, 1, 5, 8};
        int result = solution(A);

        System.out.println(result);
    }

    private static int solution(int[] A) {
        int length = A.length;

        List<Slice> slices = new ArrayList<>();

        for(int i = 0; i < length; i++){
            for(int j = i+1; j < length; j++){
                Slice slice = new Slice();
                slice.start = i;
                slice.end = j;

                slices.add(slice);
            }
        }


        double minAverage = Double.MAX_VALUE;
        int minStart = Integer.MAX_VALUE;
        for(Slice slice : slices){
            double start = slice.start;
            double end = slice.end;

            int total = 0;
            for(int i = (int)start; i <= end; i++){
                total += A[i];
            }

            double avg = total / (end - start + 1);

            if(avg < minAverage){
                minAverage = avg;
                minStart = (int)start;
            }else if(avg == minAverage){
                if(start < minStart){
                    minAverage = avg;
                    minStart = (int)start;
                }
            }
        }

        return minStart;
    }
}

class Slice {
    double start;
    double end;
}
