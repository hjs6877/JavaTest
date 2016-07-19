package com.soom.lambda;

import com.soom.lambda.domain.Person;
import com.soom.lambda.service.PersonManager;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by hjs6877 on 16. 3. 8..
 */
public class PersonTest2 {
    @Test
    public void consumerTest(){

        Consumer<Person> consumer = (Person p) -> System.out.println(p.getAge());
        consumer.accept(new Person("황정식", 30, "abcd@gmail.com"));

    }

    @Test
    public void predicateTest(){
        List<Person> list = Arrays.asList(
                new Person("황정식", 20, ""),
                new Person("김정식", 30, ""),
                new Person("이정식", 33, ""),
                new Person("윤정식", 22, "")
        );

        List<Person> result = PersonManager.filterPerson(list, p -> p.getAge() >= 30);

        for(Person p : result){
            System.out.println(p.getName());
        }
    }
}
