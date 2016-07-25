package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;

/**
 * # 그룹화
 * - Collectors.groupingBy()를 이용해서 쉽게 메뉴를 그룹화 할 수 있다.
 */
public class StreamTest11Collectors2Test {
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
         * 메뉴 타입별로 그룹화
         * - Collectors.groupingBy()를 이용해서 쉽게 메뉴를 그룹화할 수 있다.
          */
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(groupingBy(Dish::getType));

        assertEquals(3, dishesByType.entrySet().size());
        assertEquals(3, dishesByType.get(Dish.Type.MEAT).size());
        assertEquals(2, dishesByType.get(Dish.Type.FISH).size());
        assertEquals(4, dishesByType.get(Dish.Type.OTHER).size());

        System.out.println(dishesByType);
    }

    /**
     * 단순한 속성 접근자 대신 더 복잡한 분류 기준이 필요한 상황에서는 메서드 레퍼런스를
     * 분류 함수로 사용할 수 없다.
     */
    @Test
    public void streamTest2(){
        /**
         * 400 칼로리 이하를 'diet', 400~700 칼로리를 'normal', 700 칼로리 초과를 'fat' 요리로
         * 분류한다면 이러한 연산에 필요한 메서드가 없으므로 메서드 레퍼런스를 분류 함수로 사용할 수 없다.
         * 따라서 메서드 레퍼런스 대신에 람다 표현식으로 필요한 로직을 구현하여야 한다.
         */
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(dish -> {
            if (dish.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));


        assertEquals(3, dishesByCaloricLevel.entrySet().size());
        assertEquals(4, dishesByCaloricLevel.get(CaloricLevel.DIET).size());
        assertEquals(4, dishesByCaloricLevel.get(CaloricLevel.NORMAL).size());
        assertEquals(1, dishesByCaloricLevel.get(CaloricLevel.FAT).size());
    }

    /**
     * 두개의 인수를 받는 Collectors.groupingBy를 이용해서 항목을 다수준으로
     * 그룹화할 수 있다.
     * - Collectors.groupingBy는 일반적인 분류 함수와 컬렉터를 인수로 받는다.
     * 즉, 바깥쪽 groupBy 메서드에 스트림의 항목을 분류할 두 번째 기준을 정의하는 내부
     * groupBy를 전달해서 두 수준으로 스트림의 항목을 그룹화할 수 있다.
     * - 이를 활용하면 n수준으로 그룹화 할 수 있으며 n수준 그룹화의 결과는 n수준 트리 구조로
     * 표현되는 n수준 맵이 된다.
     * - groupingBy로 넘겨주는 컬렉터의 형식은 제한이 없다.
     */
    @Test
    public void streamTest3(){
        /**
         * - 요리의 타입으로 먼저 그룹화 한다.(1수준)
         * - 요리의 타입으로 그룹화 된 요소들을 CaloricLevel로 그룹화 한다.(2수준)
         */
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeByCaloricLevel =
                menu.stream().collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })
                )
        );

        assertEquals(3, dishesByTypeByCaloricLevel.entrySet().size());

        assertEquals(3, dishesByTypeByCaloricLevel.get(Dish.Type.MEAT).entrySet().size());
        assertEquals(2, dishesByTypeByCaloricLevel.get(Dish.Type.FISH).entrySet().size());
        assertEquals(2, dishesByTypeByCaloricLevel.get(Dish.Type.OTHER).entrySet().size());

        assertEquals(1, dishesByTypeByCaloricLevel.get(Dish.Type.MEAT).get(CaloricLevel.DIET).size());
        assertEquals(1, dishesByTypeByCaloricLevel.get(Dish.Type.MEAT).get(CaloricLevel.NORMAL).size());
        assertEquals(1, dishesByTypeByCaloricLevel.get(Dish.Type.MEAT).get(CaloricLevel.FAT).size());

        assertEquals(1, dishesByTypeByCaloricLevel.get(Dish.Type.FISH).get(CaloricLevel.DIET).size());
        assertEquals(1, dishesByTypeByCaloricLevel.get(Dish.Type.FISH).get(CaloricLevel.NORMAL).size());
        assertEquals(null, dishesByTypeByCaloricLevel.get(Dish.Type.FISH).get(CaloricLevel.FAT));

        assertEquals(2, dishesByTypeByCaloricLevel.get(Dish.Type.OTHER).get(CaloricLevel.DIET).size());
        assertEquals(2, dishesByTypeByCaloricLevel.get(Dish.Type.OTHER).get(CaloricLevel.NORMAL).size());
        assertEquals(null, dishesByTypeByCaloricLevel.get(Dish.Type.OTHER).get(CaloricLevel.FAT));
    }

    /**
     * groupingBy()로 넘겨주는 컬렉터의 형식은 제한이 없다.
     */
    @Test
    public void streamTest4(){
        /**
         * 메뉴의 종류별 요리의 수.
         */
        Map<Dish.Type, Long> dishesGroupCount = menu.stream().collect(groupingBy(Dish::getType, counting()));

        assertEquals(2, (long)dishesGroupCount.get(Dish.Type.FISH));
        assertEquals(3, (long)dishesGroupCount.get(Dish.Type.MEAT));
        assertEquals(4, (long)dishesGroupCount.get(Dish.Type.OTHER));
    }

    @Test
    public void streamTest5(){
        /**
         * 메뉴의 종류별로 가장 높은 칼로리를 가진 메뉴를 그룹화.
         * - 그룹화의 결과로 요리의 종류를 키로, Optional<Dish>를 값으로 갖는 맵이 반환된다.
         * - Optional<Dish>는 해당 종류의 음식 중 가장 높은 칼로리를 래핑한다.
         */
        Map<Dish.Type, Optional<Dish>> dishesByMaxCalorie = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

        assertEquals(450, dishesByMaxCalorie.get(Dish.Type.FISH).get().getCalories());
        assertEquals(800, dishesByMaxCalorie.get(Dish.Type.MEAT).get().getCalories());
        assertEquals(550, dishesByMaxCalorie.get(Dish.Type.OTHER).get().getCalories());
    }

    @Test
    public void streamTest6(){
        /**
         * 메뉴의 종류별로 그룹화 된 요리의 칼로리 합계를 반환
         */
        Map<Dish.Type, Integer> sumCaloriesByType = menu.stream().collect(
                groupingBy(
                        Dish::getType,
                        summingInt(Dish::getCalories)
                )
        );

        assertEquals(750, (int)sumCaloriesByType.get(Dish.Type.FISH));
        assertEquals(1900, (int)sumCaloriesByType.get(Dish.Type.MEAT));
    }

    /**
     * mapping()은 입력 요소를 누적하기 전에 매핑 함수를 적용해서 다양한 형식의 객체를
     * 주어진 형식의 컬렉터에 맞게 변환하는 역할을 한다.
     * - 스트림의 인수를 변환하는 함수와 변환 함수의 결과 객체를 누적하는 컬렉터를 인수로 받는다.
     */
    @Test
    public void streamTest7(){
        /**
         * 메뉴의 종류별로 그룹화 된 요리의 칼로리 레벨을 반환.
         */
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType = menu.stream().collect(
                groupingBy(
                        Dish::getType,
                        mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                },
                                toSet()
                        )
                )
        );

        System.out.println(caloricLevelByType);

        /**
         * - 위의 예에서는 Set의 형식이 정해져 있지 않았다.
         * - toCollection()을 이용하면 원하는 방식으로 결과를 제어할 수 있다.
         * - 아래와 같이 HashSet::new 메서드 레퍼런스를 toCollection()에 전달할 수 있다.
         */
        Map<Dish.Type, Set<CaloricLevel>> caloricLevelByType2 = menu.stream().collect(
                groupingBy(
                        Dish::getType,
                        mapping(
                                dish -> {
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                },
                                toCollection(HashSet::new)
                        )
                )
        );

        System.out.println(caloricLevelByType2);
    }
}
