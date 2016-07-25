package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-13.
 */
public class StreamTest2 {
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

    /**
     * 프리디케이트로 필터링
     */
    @Test
    public void streamTest1(){
        /**
         * 채식주의자만 필터링 한다.
         */
        List<Dish> vegetarianDishes =
                menu.stream()
                        .filter((Dish d) -> d.isVegetarian())
                        .collect(toList());
        assertEquals(3, vegetarianDishes.size());

        List<Dish> vegetarianDishes2 =
                menu.stream()
                        .filter(d -> d.isVegetarian())
                        .collect(toList());
        assertEquals(3, vegetarianDishes2.size());

        List<Dish> vegetarianDishes3 =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());
        assertEquals(3, vegetarianDishes3.size());


    }

    /**
     * 고유 요소 필터링. distinct()
     */
    @Test
    public void streamTest2(){
        /**
         * 짝수를 선택하고 중복 요소를 필터링한다.
         */
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Integer> distinctedNumbers = numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(toList());

        assertEquals(2, distinctedNumbers.size());
    }

    /**
     * 스트림 축소
     * filter + limit
     */
    @Test
    public void streamTest3(){
        /**
         * 고기 메뉴를 2개까지 축소한다.
         */
        List<Dish> dishes =
                menu.stream()
                        .filter(d -> d.getType() == Dish.Type.MEAT)
                        .limit(2)
                        .collect(toList());
        assertEquals(2, dishes.size());
    }

    /**
     * 스트림 축소
     * filter + limit
     */
    @Test
    public void streamTest4(){
        /**
         * 칼로리가 300 보다 큰 메뉴를 3개로 축소한다.
         */
        List<Dish> dishes =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(toList());

        assertEquals(3, dishes.size());
    }

    /**
     * 스트림 요소 건너뛰기
     */
    @Test
    public void streamTest5(){
        /**
         * 300 칼로리가 넘는 처음 두 요리를 건너뛴 다음에 300칼로리가 넘는 나머지 요리를 반환한다.
         */
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        assertEquals("chicken", dishes.get(0).getName());
    }


    @Test
    public void streamTest6(){
        /**
         * 처음 등장하는 두 고기 요리를 필터링.
         */
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());

        assertEquals("pork", dishes.get(0).getName());
        assertEquals("beef", dishes.get(1).getName());
    }

}
