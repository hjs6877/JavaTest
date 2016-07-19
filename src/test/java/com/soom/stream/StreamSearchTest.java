package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-15.
 */
public class StreamSearchTest {
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
    public void findAnyTest(){
        /**
         * findAny(): 임의의 요소를 래핑한 Optional<Dish>을 반환한다.
         * - Optional<T>: 값이 존재하는지 확인하고, 값이 없을 때 어떻게 처리할 것인지 강제하는 기능을 제공한다.
         * ifPresent(Consumer<T> block): 값이 있으면 주어진 블록을 실행한다.
         */
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        /**
         * isPresent(): Optional이 값을 포함하면 true, 값을 포함하지 않으면 false를 반환한다.
         */
        boolean result = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .isPresent();
        assertEquals(true, result);

        /**
         * get(): Optional이 값을 포함하면 값을 반환하고, 값이 없으면 NoSuchElementException 예외를 발생시킨다.
         */
        Dish dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .get();

        assertEquals("rice", dish.getName());


        /**
         * orElse(): Optional이 값이 있으면 값을 반환하고, 값이 없으면 기본값을 반환한다.
         */
        Dish dish2 = menu.stream()
                .filter(d -> d.getCalories() >= 300)
                .findAny()
                .orElse(new Dish("NoFood", false, 0, Dish.Type.OTHER));
        assertEquals("pork", dish2.getName());


        Dish dish3 = menu.stream()
                .filter(d -> d.getCalories() >= 1000)
                .findAny()
                .orElse(new Dish("NoFood", false, 0, Dish.Type.OTHER));
        assertEquals("NoFood", dish3.getName());
    }
}
