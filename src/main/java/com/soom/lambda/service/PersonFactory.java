package com.soom.lambda.service;

import com.soom.lambda.domain.Person;

/**
 * Created by kjs on 2016-07-14.
 */
public class PersonFactory {
    public static Person getInstaance(String name, int age, String email){
        return new Person(name, age, email);
    }
}
