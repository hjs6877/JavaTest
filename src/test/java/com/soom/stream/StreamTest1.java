package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * ## 스트림 정리
 * 1. 스트림이란?
 * : 데이터 처리 연산을 지원하도록 소스에서 추출된 연속된 요소.
 *      (1) 연속된 요소
 *          - 스트림은 특정 요소 형식으로 이루어진 연속된 값 집합의 인터페이스를 제공한다.
 *          - 컬렉션의 주제는 요소 저장 및 접근 연산이 주를 이룬다.
 *          - 스트림의 주제는 계산이다.
 *      (2) 소스
 *          - 스트림은 컬렉션, 배열, I/O 자원 등의 데이터 제공 소스로부터 데이터를 소비한다.
 *      (3) 데이터 처리 연산
 *          - 스트림은 함수형 프로그래밍 언어에서 일반적으로 지원하는 연산과 데이터베이스와 비슷한 연산을 지원한다.
 *
 * 2. 스트림의 특징
 *      (1) 파이프라이닝
 *          - 대부분의 스트림 연산은 스트림 연산끼리 연결해서 커다란 파이파라인을 구성할 수 있도록 스트림 자신을 반환한다.
 *      (2) 내부 반복
 *          - 반복자를 이용해서 명시적으로 반복하는 컬렉션과 달리 스트림은 내부 반복을 지원한다.
 *          - 내부 반복을 이용하면 작업을 투명하게 병렬로 처리하거나 더 최적화된 다양한 순서로 처리할 수 있다.
 *      (3) 한번 탐색된 스트림은 소비되므로 한 번 탐색한 요소를 다시 탐색하려면 초기 데이터 소스에서 새로운 스트림을 만들어야 한다.
 *
 * 3. 스트림 연산
 *      (1) 중간 연산
 *              1) 연결할 수 있는 스트림 연산
 *              2) 최종 연산을 실행하기 전까지는 아무 연산도 수행하지 않는다.
 *              3) 중간 연산의 종류
 *                  A) filter
 *                      - 람다를 인수로 받아 스트림에서 조건에 맞는 요소만을 선택한다.
 *                  B) map
 *                      - 람다를 이용해서 한 요소를 다른 요소로 변환하거나 정보를 추출한다.
 *                  C) limit
 *                      - 정해진 개수 이상의 요소가 스트림에 저장되지 못하게 스트림 크기를 축소 한다.
 *      (2) 최종 연산
 *              1) 스트림을 닫는 연산
 *              2) 스트림 파이프라인에서 결과를 도출한다.
 *              3) 최종 연산의 종류
 *                  A) collect
 *                      - 다양한 변환 방법을 인수로 받아 스트림에 누적된 요소를 특정 결과인 다른 형식으로 변환한다.
 *                  B) forEach
 *                      - 스트림의 각 요소를 소비하면서 람다를 적용한 후, void를 반환한다.
 *                  C) count
 *                      - 스트림의 요소 개수를 반환한다. long을 반환한다.
 *
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

}
