package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

/**
 * # Collector
 * - Collector 인터페이스 구현체는 스트림의 요소를 어떤 식으로 도출할지를 지정한다.
 * - 5장에서는 '각 요소를 리스트로 만들어라'를 의미하는 toList()를 Collector 인터페이스의 구현체로 사용했다.
 * - 6장에서는 '각 키(통화) 버킷 그리고 각 키 버킷에 대응하는 요소 리스트를 값으로 포함하는 맵을 만들라'는 동작을 수행한다.
 * - 다수준으로 그룹화를 수행할 때 명령형 코드에서는 다중 루프와 조건문을 추가하며 가독성과 유지보수성이 크게 떨어지는 반면에
 * 함수형 프로그래밍에서는 필요한 컬렉터를 쉽게 추가할 수 있다.
 * - collect로 결과를 수집하는 과정을 간단하면서도 유연한 방식으로 정의할 수 있다는 점이 컬렉터의 최대 강점이다.
 * - Collectors에서 제공하는 메서드의 기능은 크게 세가지로 구분할 수 있다.
 *      - 스트림 요소를 하나의 값으로 리듀스하고 요약
 *      - 요소 그룹화
 *      - 요소 분할
 */
public class StreamTest10Collectors1Test {
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
    public void streamCollectorTest1(){
        /**
         * - Collectors.counting()을 사용하여 요리 갯수를 계산할 수 있다.
         * - counting 컬렉터는 다른 컬렉터와 함께 사용할 때 위력을 발휘한다.
         */
        long howManyDishes = menu.stream().collect(counting());
        assertEquals(9, howManyDishes);
    }

    @Test
    public void streamCollectorTest2(){
        /**
         * 객체의 스트림 값에서 최대값과 최소값을 가지는 객체를 검색
         * - Collectors.maxBy()와 Collectors.minBy()를 이용해서 구할 수 있다.
         * - 앞장의 예제와 다른점은 mapToInt()로 추출하거나 reduce()이용하여 최대값, 최소값을 구하는것이 아니라 최대값, 최소값을
         * 가지는 객체를 검색한다는것이다. 그러기 위해서는 스트림의 요소를 비교하는데 사용할 Comparator를 인수로 받는다.
         */
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCalorieDish = menu.stream().collect(maxBy(dishCaloriesComparator));

        assertEquals("pork", maxCalorieDish.get().getName());

        Optional<Dish> minCalorieDish = menu.stream().collect(minBy(dishCaloriesComparator));
        assertEquals("season", minCalorieDish.get().getName());
    }

    @Test
    public void streamCollectorTest3(){
        /**
         * Collectors.summingInt()를 사용하여 칼로리의 총 합계를 계산.
         */
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        assertEquals(4200, totalCalories);
    }

    @Test
    public void streamCollectorTest4(){
        /**
         * Collectors.averagingInt() 사용하여 칼로리의 평균을 계산.
         */
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));

        assertEquals(466.6666666666667, avgCalories, 0);
    }

    @Test
    public void streamCollectorTest5(){
        /**
         * SummaryStatistics 를 이용하여 한번에 요약하기.
         */
        IntSummaryStatistics menuStatistics = menu.stream().collect(summarizingInt(Dish::getCalories));

        assertEquals(9, menuStatistics.getCount());
        assertEquals(800, menuStatistics.getMax());
        assertEquals(120, menuStatistics.getMin());
        assertEquals(4200, menuStatistics.getSum());
        assertEquals(466.6666666666667, menuStatistics.getAverage(), 0);
    }

    @Test
    public void streamCollectorTest6(){
        /**
         * Collectors.joining()을 이용하여 문자열 연결.
         */
        String shortMenuNoSeparator = menu.stream().map(Dish::getName).collect(joining());
        assertEquals("porkbeefchickenfrench friesriceseasonpizzaprawnssalmon", shortMenuNoSeparator);

        String shorMenu = menu.stream().map(Dish::getName).collect(joining(", "));
        assertEquals("pork, beef, chicken, french fries, rice, season, pizza, prawns, salmon", shorMenu);
    }
}
