package com.soom.hackerrank.inheritance;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-01-11 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class Student extends Person {
    Student(String firstName, String lastName, int identification) {
        super(firstName, lastName, identification);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String firstName = in.next();
        String lastName = in.next();
        int idNumber = in.nextInt();
        int scoresCount = in.nextInt();
        int[] testScores = new int[scoresCount];

        for(int i=0; i< scoresCount; i++){
            testScores[i] = in.nextInt();
        }

        Student student = new Student(firstName, lastName, idNumber);
        student.printPerson();

        String grade = student.getGrade(testScores);
        student.printGrade(grade);
    }

    private void printGrade(String grade) {
        System.out.println("Grade: " + grade);
    }

    public String getGrade(int[] scores){
        double avg =getAvg(scores);
        String grade = null;

        if(avg >= 90 && avg <= 100)
            grade = "O";
        else if(avg >= 80 && avg < 90)
            grade = "E";
        else if(avg >= 70 && avg < 80)
            grade = "A";
        else if(avg >= 55 && avg < 70)
            grade = "P";
        else if(avg >= 40 && avg < 55)
            grade = "D";
        else if(avg < 40)
            grade = "T";
        return grade;
    }

    private double getAvg(int[] scores) {
        double totalScore = getTotalScore(scores);
        return totalScore / scores.length;
    }

    private double getTotalScore(int[] scores) {
        double totalScore = 0.0;
        for(int i = 0; i < scores.length; i++){
            totalScore += scores[i];
        }
        return totalScore;
    }
}
