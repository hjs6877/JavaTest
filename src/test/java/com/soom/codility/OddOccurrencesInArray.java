package com.soom.codility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OddOccurrencesInArray {
    public static void main(String[] args){
        int[] A = {3,4,3,5,5,6,7,7,6};

        System.out.println(new OddOccurrencesInArray().solution(A));
    }

    public int solution(int[] A) {
        Map<Integer, Boolean> paired = new HashMap<>();

        for(int a : A){
            if(paired.get(a) == null){
                paired.put(a, true);
            }else {
                paired.remove(a);
            }
        }

        List<Integer> unpairedList = new ArrayList<>(paired.keySet());

        return unpairedList.get(0);
    }
}
