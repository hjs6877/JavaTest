package com.soom.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kjs on 2016-07-15.
 */
public class StreamTest3 {
    @Test
    public void distinctTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        numbers.stream()
                .filter((Integer i) -> i % 2 ==0)
                .distinct()
                .forEach(System.out::println);
    }
}
