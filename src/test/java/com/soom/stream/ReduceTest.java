package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * 리듀싱
 * - 모든 스트림의 요소를 처리해서 값으로 도출하는 연산.
 * - 리듀스를 이용하면 애플리케이션의 반복된 패턴을 추상화 할 수 있다.
 * - reduce를 이용하면 내부 반복이 추상화 되면서 내부 구현에서 병렬로 reduce를 실행할 수 있겠된다.
 */
public class ReduceTest {
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
     * 리스트의 요소를 모두 더하는 기존의 방법
     */
    @Test
    public void simpleForEachTest(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6);
        int sum = 0;
        for(int x : numbers){
            sum += x;
        }

        assertEquals(15, sum);
    }

    @Test
    public void reduceTest1(){
        List<Integer> numbers = Arrays.asList(1, 3, 5, 6);

        /**
         * reduce(initValue, BinaryOperator<T,T>
         * 스트림의 모든 요소를 차례로 더한다.
         */
        int sum = numbers.stream()
                            .reduce(0, (a, b) -> a + b);
        assertEquals(15, sum);

        /**
         * 메서드 레퍼런스를 이용해서 코드를 좀 더 간결하게 만들 수 있다.
         */
        int sum2 = numbers.stream()
                .reduce(0, Integer::sum);
        assertEquals(15, sum2);

        /**
         * 스트림의 모든 요소를 차례로 곱한다.
         */
        int product = numbers.stream()
                            .reduce(1, (a, b) -> a * b);
        assertEquals(90, product);

        /**
         * 초기값이 없는 reduce ()를 사용하면 Optional 객체를 반환한다.
         */
        Optional<Integer> optional = numbers.stream()
                                            .reduce((a, b) -> a + b);
        assertEquals(15, (int)optional.get());
        assertEquals(true, optional.isPresent());
        optional.ifPresent(num -> assertEquals(15, (int) num));
        assertEquals(15, (int) optional.orElse(0));

        /**
         * 스트림 요소에서 최대값 반환.
         */
        Optional<Integer> maxOptional = numbers.stream()
                                                .reduce(Integer::max);
        assertEquals(6, (int)maxOptional.get());

        /**
         * 스트림 요소에서 최소값 반환.
         */
        Optional<Integer> minOptional = numbers.stream()
                                                .reduce(Integer::min);
        assertEquals(1, (int)minOptional.get());

    }

    @Test
    public void reduceTest2(){
        int count = menu.stream()
                        .map(d -> 1)
                        .reduce(0, (a, b) -> a + b);

        assertEquals(9, count);
    }
}
