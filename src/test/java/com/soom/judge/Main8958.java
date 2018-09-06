package com.soom.judge;

import java.util.Scanner;

public class Main8958 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] cases = new String[num];
        for(int i = 0; i < cases.length; i++){
            cases[i] = scanner.next();
        }
        scanner.close();

        for(String ox : cases){
            int count = 0;
            int total = 0;
            for(int i = 0; i < ox.length(); i++){
                char c = ox.charAt(i);
                if(c == 'O'){
                    total += ++count;
                }else{
                    count = 0;
                }
            }
            System.out.println(total);
        }
    }
}
