package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kjs on 2016-07-15.
 */
public class StreamMatchTest {
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
    public void anyMathTest(){
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("채식위주의 식단이 있습니다.");
        }
    }

    @Test
    public void allMatchTest(){
        if(menu.stream().allMatch(d -> d.getCalories() < 1000)){
            System.out.println("모든 식단은 저칼로리 건강식입니다.");
        }
    }

    @Test
    public void noneMatchTest(){
        if(menu.stream().noneMatch(d -> d.getCalories() >= 1000)){
            System.out.println("고칼로리 식단은 없습니다.");
        }
    }
}
