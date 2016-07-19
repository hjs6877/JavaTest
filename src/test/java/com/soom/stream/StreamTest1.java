package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by kjs on 2016-07-13.
 */
public class StreamTest1 {
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
       List<String> names =
               menu.stream()
                   .filter(d -> {
                       System.out.println("filtering: " + d.getName());
                       return d.getCalories() > 300;
                   })
                   .map(d -> {
                       System.out.println("mapping: " + d.getName());
                       return d.getName();
                   })
                   .limit(3)
                   .collect(toList());
        System.out.println(names);
    }

    @Test
    public void streamTest2(){
        menu.stream().forEach(System.out::println);
    }
}
