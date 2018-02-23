package com.soom.hackerrank.inheritance;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-01-11 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class Person {
    protected String firstName;
    protected String lastName;
    protected int idNumber;

    Person(String firstName, String lastName, int identification){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = identification;
    }

    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName + "\nID: " + idNumber
        );
    }
}
