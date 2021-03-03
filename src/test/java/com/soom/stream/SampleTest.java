package com.soom.stream;

import org.junit.Test;

import java.util.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by kjs on 2016-07-13.
 */
public class SampleTest {
    @Test
    public void NotUsingStreamTest(){
        List<Dish> menu = Arrays.asList(
                new Dish("파스타", false, 400, Dish.Type.MEAT)
                , new Dish("짜장면", false, 400, Dish.Type.MEAT)
                , new Dish("샐러드", false, 200, Dish.Type.MEAT)
                , new Dish("햄버거", false, 500, Dish.Type.MEAT)
                , new Dish("커피", false, 150, Dish.Type.MEAT)
        );

        List<Dish> lowCaloriDishes = new ArrayList<>();
        for(Dish d : menu){
            if(d.getCalories() < 400){
                lowCaloriDishes.add(d);
            }
        }

        Collections.sort(lowCaloriDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });


        List<String> lowCaloriDishesName = new ArrayList<>();
        for(Dish d : lowCaloriDishes){
            System.out.println(d.getName());
            lowCaloriDishesName.add(d.getName());
        }
    }

    @Test
    public void DishesFilterTest(){
        List<Dish> menu = Arrays.asList(
                new Dish("파스타", false, 400, Dish.Type.MEAT)
                , new Dish("짜장면", false, 400, Dish.Type.MEAT)
                , new Dish("샐러드", false, 200, Dish.Type.MEAT)
                , new Dish("햄버거", false, 500, Dish.Type.MEAT)
                , new Dish("커피", false, 150, Dish.Type.MEAT)
        );

        /**
         * 400칼로리 이하의 식단을 칼로리 순으로 정렬한 후, 식단명을 반환.
         */
        List<String> lowCaloriDishesName =
                menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());

        for(String dName : lowCaloriDishesName){
            System.out.println(dName);
        }

    }
}
