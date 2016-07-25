package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * # 요소 검색
 * Optional이란?
 * - null은 쉽게 에러를 일으킬 수 있기때문에 자바 8에 Optional<T> 기능이 추가 됨.
 * - Optional은 값이 존재하는지 확인하고 값이 없을 때 어떻게 처리할 것인지 강제하는 기능을 제공함.
 */
public class StreamTest5SearchTest {
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

    /**
     * 첫번째 요소 찾기
     */
    @Test
    public void findFirstTest(){
        /**
         * 숫자 리스트에서 각각의 요소를 제곱하여 3으로 나누어 떨어지는 첫번째 제곱값을 반환하는 예.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 3, 6, 8);
        Optional<Integer> result = numbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();

        assertEquals(9, (int)result.get());
    }

    /**
     * findAny와 findFirst 두 가지 메서드가 필요한 이유는 병렬성 때문이다.
     * 병렬 실행에서는 첫 번째 요소를 찾기 어렵다. 따라서 요소의 반환 순서가 상관없다면 병렬 스트림에서는
     * 제약이 적은 findAny를 사용한다.
     */
}
