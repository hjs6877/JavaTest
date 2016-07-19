package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-15.
 */
public class StreamReduceTest {
    private static List<Dish> menu;

    @BeforeClass
    public static void beforeClass(){
        menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT)
                , new Dish("beef", false, 700, Dish.Type.MEAT)
                , new Dish("chicken", false, 400, Dish.Type.MEAT)
                , new Dish("french fries", false, 530, Dish.Type.OTHER)
                , new Dish("rice", true, 350, Dish.Type.OTHER)
                , new Dish("season", true, 120, Dish.Type.OTHER)
                , new Dish("pizza", true, 550, Dish.Type.OTHER)
                , new Dish("prawns", false, 300, Dish.Type.FISH)
                , new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }

    @Test
    public void simpleForEachTest(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6);
        int sum = 0;
        for(int x : numbers){
            sum += x;
        }

        assertEquals(15, sum);
    }

    @Test
    public void reduceTest1(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6);

        /**
         * reduce(initValue, BinaryOperator<T,T>
         * 스트림의 모든 요소를 차례로 더한다.
         */
        int sum = numbers.stream()
                            .reduce(0, (a, b) -> a + b);
        assertEquals(15, sum);

        int sum2 = numbers.stream()
                .reduce(0, Integer::sum);
        assertEquals(15, sum2);

        /**
         * 스트림의 모든 요소를 차례로 곱한다.
         */
        int product = numbers.stream()
                            .reduce(1, (a, b) -> a * b);
        assertEquals(90, product);

        /**
         * 초기값이 없는 reduce ()를 사용하면 Optional 객체를 반환한다.
         */
        Optional<Integer> optional = numbers.stream()
                                            .reduce((a, b) -> a + b);
        assertEquals(15, (int)optional.get());
        assertEquals(true, optional.isPresent());
        optional.ifPresent(num -> assertEquals(15, (int) num));
        assertEquals(15, (int) optional.orElse(0));

        /**
         * 스트림 요소에서 최대값 반환.
         */
        Optional<Integer> maxOptional = numbers.stream()
                                                .reduce(Integer::max);
        assertEquals(6, (int)maxOptional.get());

        Optional<Integer> minOptional = numbers.stream()
                                                .reduce(Integer::min);
        assertEquals(1, (int)minOptional.get());

    }

    @Test
    public void reduceTest2(){
        int count = menu.stream()
                        .map(d -> 1)
                        .reduce(0, (a, b) -> a + b);

        assertEquals(9, count);
    }
}
