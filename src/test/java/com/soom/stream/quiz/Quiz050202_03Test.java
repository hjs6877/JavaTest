package com.soom.stream.quiz;

import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz050202_03Test {
    private static List<Integer> source1;
    private static List<Integer> source2;

    @BeforeClass
    public static void beforeClass(){
        source1 = Arrays.asList(1, 2, 3);
        source2 = Arrays.asList(3, 4);

    }

    @Test
    public void quiz050202Test() {
        List<int[]> result = source1.stream()
                .flatMap(n -> source2.stream().map(m -> new int[]{n, m})).collect(Collectors.toList());

        result.stream().forEach(arr -> System.out.println("(" + arr[0] + "," + arr[1] + ")"));
    }

    @Test
    public void quiz050203Test() {
        List<int[]> result =
                source1.stream()
                        .flatMap(n ->
                                        source2.stream()
                                                .filter(m -> (n + m) % 3 == 0)
                                                .map(m -> new int[]{n, m})
                        )
                        .collect(Collectors.toList());


        result.stream().forEach(pair -> System.out.println("(" + pair[0] + "," + pair[1] + ")"));
    }
}
