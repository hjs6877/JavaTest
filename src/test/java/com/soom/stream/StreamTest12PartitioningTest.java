package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

/**
 * # 분할(partitioning)
 * - 분할은 분할 함수(partitioning function)라 불리는 프리디케이트를 분류 함수로 사용하는 특수한 그룹화 기능이다.
 * - 분할 함수가 반환하는 참, 거짓 두 가지 요소의 스트림 리스트를 모두 유지한다는 것이 분할의 장점이다.
 */
public class StreamTest12PartitioningTest {
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
        /**
         * 채식인 요리와 그렇지 않은 요리로 분할한다.
         */
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));

        assertEquals(3, partitionedMenu.get(true).size());
        assertEquals(6, partitionedMenu.get(false).size());

        System.out.println("### 채식 요리");
        partitionedMenu.get(true).stream().forEach(d -> System.out.println(d.getName()));

        System.out.println("### 채식이 아닌 요리");
        partitionedMenu.get(false).stream().forEach(d -> System.out.println(d.getName()));
    }

    @Test
    public void streamTest2(){
        /**
         * 채식인 요리와 그렇지 않은 요리로 분할 후, 각각 요리 종류로 그룹화 한다.
         */
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        assertEquals(null, vegetarianDishesByType.get(true).get(Dish.Type.MEAT));
        assertEquals(null, vegetarianDishesByType.get(true).get(Dish.Type.FISH));
        assertEquals(3, vegetarianDishesByType.get(true).get(Dish.Type.OTHER).size());

        assertEquals(3, vegetarianDishesByType.get(false).get(Dish.Type.MEAT).size());
        assertEquals(2, vegetarianDishesByType.get(false).get(Dish.Type.FISH).size());
        assertEquals(1, vegetarianDishesByType.get(false).get(Dish.Type.OTHER).size());
    }

    @Test
    public void streamTest3(){
        /**
         * 채식 요리와 그렇지 않은 요리로 분할 후, 각각의 칼로리가 가장 높은 요리를 찾는다.
         */
        Map<Boolean, Optional<Dish>> maxCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, maxBy(Comparator.comparingInt(Dish::getCalories))));

        assertEquals(550, maxCaloricPartitionedByVegetarian.get(true).get().getCalories());
        assertEquals(800, maxCaloricPartitionedByVegetarian.get(false).get().getCalories());
    }

    @Test
    public void streamTest4(){
        /**
         * 채식 요리와 그렇지 않은 요리로 분할 후, 각각의 요리를 다시 500칼로리가 넘는 요리와 그렇지 않은 요리로 분할 한다.
         */
        Map<Boolean, Map<Boolean, List<Dish>>> multiPartitioningBy1 = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));

        assertEquals(1, multiPartitioningBy1.get(true).get(true).size());
        assertEquals(2, multiPartitioningBy1.get(true).get(false).size());

        assertEquals(3, multiPartitioningBy1.get(false).get(true).size());
        assertEquals(3, multiPartitioningBy1.get(false).get(false).size());
    }

    @Test
    public void streamTest5(){
        /**
         * 채식 요리와 그렇지 않은 요리로 분할 후, 각각의 요리의 갯수를 얻는다.
         */
        Map<Boolean, Long> vegetarianCount = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));

        assertEquals(3, (long)vegetarianCount.get(true));
        assertEquals(6, (long)vegetarianCount.get(false));
    }

}
