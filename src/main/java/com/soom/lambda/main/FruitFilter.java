package com.soom.lambda.main;

import com.soom.lambda.domain.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ideapad on 2016-03-06.
 */
public class FruitFilter {
    public static void main(String[] args){
        List appleList = Arrays.asList(new Apple(100, "green"), new Apple(200, "red"));
        List<Apple> result = filterGreenApples(appleList);
    }

    private static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : apples){
            if(apple.getColor().equals("green")){
                result.add(apple);
            }
        }
        return result;
    }
}
