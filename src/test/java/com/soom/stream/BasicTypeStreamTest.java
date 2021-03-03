package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * 기본형에 특화된 스트림 예제. IntStream, LongStream, DoubleStream
 */
public class BasicTypeStreamTest {
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
    public void streamTest1(){
        /**
         * IntStream을 사용하여 합계를 계산할때 박싱을 하지 않아도 된다.
         */
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        assertEquals(4200, calories);

        /**
         * 합계 예제에서는 0이라는 기본값이 있었으므로 문제가 없으나 IntStream에서
         * 최대값을 찾을 때는 0이라는 기본값때문에 잘못된 결과가 도출될 수 있으므로
         * 스트림에 요소가 없는 상황에서 사용할 수 있는 기본형에 특화된 Optional을 지원한다.
         */
        OptionalInt optionalInt = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        assertEquals(800, optionalInt.getAsInt());
    }

    @Test
    public void streamTest2(){
        /**
         * 1부터 100까지등의 특정 범위의 숫자를 이용해야 하는 상황에서 이용할 수 있는 기본형에 특화된 스트림의 메서드
         */
        long count = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        assertEquals(50, count); // 1부터 100까지 50개의 짝수가 있음.

        OptionalInt optionalIntMax = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .max();
        assertEquals(100, optionalIntMax.getAsInt());

        OptionalInt optionalIntMin = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .min();
        assertEquals(2, optionalIntMin.getAsInt());

        /**
         * range 메서드는 시작값과 종료값이 결과에 포함되지 않지만
         * rangeClosed는 시작값과 종료값이 결과에 포함된다.
         */
    }

}
