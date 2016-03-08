package com.soom.lambda.service;

import com.soom.lambda.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by ideapad on 2016-03-08.
 */
public class PersonManager {
    public static List<Person> filterPerson(List<Person> list, Predicate<Person> p){
        List<Person> result = new ArrayList<>();

        for(Person person : list){
            if(p.test(person)){
                result.add(person);
            }
        }

        return result;
    }
}
