package com.soom.codility;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public static void main(String[] args){
        int[] A = {2, 1, 1, 2, 3, 1};

        int result = solution(A);

        System.out.println(result);
    }

    private static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int a : A){
            set.add(a);
        }

        return set.size();
    }
}
