package com.soom.hackerrank.abstractexample;

import java.util.Scanner;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-01-31 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
abstract class Book {
    String title;
    String author;
    Book(String t, String a){
        title = t;
        author = a;
    }

    abstract void display();
}

class Mybook extends Book {
    int price;
    Mybook(String t, String a, int price) {
        super(t, a);
        this.price = price;
    }

    @Override
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        String author = sc.nextLine();
        int price = sc.nextInt();

        Book newNovel = new Mybook(title, author, price);
        newNovel.display();
    }
}