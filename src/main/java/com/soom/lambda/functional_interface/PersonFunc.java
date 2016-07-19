package com.soom.lambda.functional_interface;

import com.soom.lambda.domain.Person;

/**
 * Created by kjs on 2016-07-14.
 */
public interface PersonFunc {
    public Person apply(String name, int age, String email);
}
