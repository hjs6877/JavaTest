package com.soom.codility;

public class FrogJump {
    public static void main(String[] args){
        int x = 40;
        int y = 190;
        int d = 35;
        int count = solution(x, y, d);

        System.out.println(count);
    }

    private static int solution(int X, int Y, int D) {
        int count;
        int quotient = (Y - X) / D;
        int remainder = (Y - X) % D;

        if(remainder == 0){
            count = quotient;
        }else{
            count = quotient + 1;
        }
        return count;
    }
}
