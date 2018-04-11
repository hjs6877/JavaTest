package com.soom.hackerrank.algorithms.implementation;

import java.util.Scanner;

public class GradingStudents {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


    }

    static int[] solve(int[] grades){
        int[] result = new int[grades.length];
        for(int i = 0 ; i < grades.length; i++){
            int grade = grades[i];
            if(grades[i] < 38){
                result[i] = grades[i];
            }else{
                int remainder = grade % 5;

                if(5 - remainder < 3){
                    result[i] = grade + (5-remainder);
                }else{
                    result[i] = grade;
                }
            }
        }
        return result;
    }

}
