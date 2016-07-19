package com.soom.lambda;

import com.soom.lambda.domain.Apple;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static java.util.Comparator.comparing;

/**
 * Created by kjs on 2016-07-11.
 */
public class FruitSortTest {
    @Test
    public void sortFruitTest1(){
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green")
                , new Apple(155, "green")
                , new Apple(120, "red")
        );

        /**
         * 사과를 무게 순으로 오름차순 정렬
         */
        inventory.sort(comparing(Apple::getWeight));

        for(Apple apple : inventory){
            System.out.println(apple.getWeight());
        }
    }

    @Test
    public void sortFruitTest2(){
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green")
                , new Apple(155, "green")
                , new Apple(120, "red")
        );

        /**
         * 사과를 무게순으로 내림차순 정렬
         */
        inventory.sort(comparing(Apple::getWeight).reversed());

        for(Apple apple : inventory){
            System.out.println(apple.getWeight());
        }
    }

    @Test
    public void sortFruitTest3(){
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green")
                , new Apple(155, "green")
                , new Apple(120, "red")
                , new Apple(120, "green")
        );

        /**
         * 사과를 무게순으로 내림차순 정렬 후, 동일한 무게일 경우 색깔별로 오름차순 정렬.
         */
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

        for(Apple apple : inventory){
            System.out.println(apple.getWeight() + " : " + apple.getColor());
        }
    }
}
