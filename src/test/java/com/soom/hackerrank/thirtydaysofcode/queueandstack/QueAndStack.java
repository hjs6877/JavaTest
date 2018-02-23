package com.soom.hackerrank.thirtydaysofcode.queueandstack;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-10 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class QueAndStack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        QueAndStack qas = new QueAndStack();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            qas.pushCharacter(c);
            qas.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (qas.popCharacter() != qas.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }

    private char dequeueCharacter() {
        char c = '\u0000';
        return c;
    }

    private char popCharacter() {
        char c = '\u0000';
        return c;
    }

    private void enqueueCharacter(char c) {

    }

    private void pushCharacter(char c) {

    }
}

