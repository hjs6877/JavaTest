package com.soom.judge;

import java.util.Scanner;

public class CountWord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();

        if(!s.isEmpty())
            System.out.println(s.split(" ").length);
        else
            System.out.println(0);
    }
}
