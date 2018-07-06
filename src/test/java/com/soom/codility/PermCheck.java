package com.soom.codility;

public class PermCheck {
    public static void main(String[] args){
        int[] A = {4, 1, 3, 4};
        int isPerm = solution(A);

        System.out.println(isPerm);
    }

    private static int solution(int[] A) {

        boolean[] isPerms = new boolean[A.length + 1];

        for(int idx : A){
            if(idx < isPerms.length)
                isPerms[idx] = true;
        }

        for(int i = 1; i < isPerms.length; i++){
            if(!isPerms[i])
                return 0;
        }
        return 1;
    }
}
