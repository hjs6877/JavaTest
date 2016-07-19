package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by kjs on 2016-07-15.
 */
public class StreamMapTest {
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
     * 요리명 추출.
     */
    @Test
    public void extractDishNameTest(){
        List<String> dishNames = menu.stream()
                .map(d -> d.getName())
                .collect(toList());

        for(String dishName : dishNames){
            System.out.println(dishName);
        }
    }

    /**
     * 문자열 길이 추출.
     */
    @Test
    public void extractStringLengthTest(){
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        for(int length : wordLengths){
            System.out.println(length);
        }
    }

    /**
     * 요리명의 길이 추출.
     */
    @Test
    public void extractDishNamesLengthTest(){
        List<Integer> dishNamesLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());

        for(int length : dishNamesLengths){
            System.out.println(length);
        }
    }

}
