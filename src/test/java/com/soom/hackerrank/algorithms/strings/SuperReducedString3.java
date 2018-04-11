package com.soom.hackerrank.algorithms.strings;

import java.util.Scanner;

public class SuperReducedString3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }

    static String super_reduced_string(String str) {
        char []remains = new char[str.length()];
        int top = -1; // highest valid index

        for (char c: str.toCharArray())
            if (top < 0 || c != remains[top])
                remains[++top] = c;
            else
                --top;

        return top < 0 ? "Empty String" : new String(remains, 0, top+1);
    }
}
