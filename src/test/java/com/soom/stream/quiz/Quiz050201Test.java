package com.soom.stream.quiz;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toList;

public class Quiz050201Test {
    private static List<Integer> source;

    @BeforeClass
    public static void beforeClass() {
        source = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    public void quiz050201Test() {
        List<Integer> result = source.stream().map(num -> num * num).collect(toList());

        System.out.println(result);
    }
}
