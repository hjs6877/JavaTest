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
     * 채식주의자만 필터링 한다.
     */
    @Test
    public void streamTest2(){
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

    @Test
    public void limitTest(){
        List<Dish> dishes =
              menu.stream()
                      .filter(d -> d.getCalories() > 300)
                      .limit(3)
                      .collect(toList());

        assertEquals(3, dishes.size());


    }

    @Test
    public void filterByMeatTest(){
        List<Dish> dishes =
                menu.stream()
                    .filter(d -> d.getType() == Dish.Type.MEAT)
                    .limit(2)
                    .collect(toList());
        assertEquals(2, dishes.size());
    }
}
