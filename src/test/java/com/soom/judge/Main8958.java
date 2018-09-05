package com.soom.judge;

import java.util.Scanner;

public class Main8958 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String[] cases = new String[count];
        for(int i = 0; i < cases.length; i++){
            cases[i] = scanner.next();
        }
        scanner.close();

        for(String ox : cases){
            char[] oxs = ox.toCharArray();
            int sum = 0;
            for(int i = 0; i < oxs.length; i++){
                if(oxs[i] == 'O'){
                    for(int j = i; j >= 0; j--){
                        if(oxs[j] == 'O'){
                            sum++;
                        }else{
                            break;
                        }
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
