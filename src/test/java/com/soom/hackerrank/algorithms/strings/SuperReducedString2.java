package com.soom.hackerrank.algorithms.strings;

import java.util.Scanner;

public class SuperReducedString2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }

    static String super_reduced_string(String str) {
        int length = str.length();

        int i = 0;
        while(i < length - 1){
            int current = str.charAt(i);
            int next = str.charAt(i+1);

            if(current == next){
                str = str.substring(0, i) + str.substring(i+2);
                i = 0;
                length = str.length();
                continue;
            }else{
                i++;
            }
        }

        if(length == 0){
            str = "Empty String";
        }
        return str;
    }
}
