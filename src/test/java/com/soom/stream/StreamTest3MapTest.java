package com.soom.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * # 매핑
 * - 특정 객체에서 특정 데이터를 선택하는 작업은 데이터 처리 과정에서 자주 수행되는 연산이다.
 * - map과 flatMap 메서드는 특정 데이터를 선택하는 기능을 제공한다.
 */
public class StreamTest3MapTest {
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
    public void streamTest1(){
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
    public void streamTest2(){
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengthList = words.stream()
                .map(s -> s.length())
                .collect(toList());
        assertEquals(5, (int)wordLengthList.get(0));
        assertEquals(7, (int)wordLengthList.get(1));
        assertEquals(2, (int)wordLengthList.get(2));
        assertEquals(6, (int) wordLengthList.get(3));

        List<Integer> wordLengthList2 = words.stream()
                .map(String::length)    // 메서드 레퍼런스를 사용.
                .collect(toList());

        assertEquals(5, (int)wordLengthList2.get(0));
        assertEquals(7, (int)wordLengthList2.get(1));
        assertEquals(2, (int)wordLengthList2.get(2));
        assertEquals(6, (int)wordLengthList2.get(3));
    }

    /**
     * 스트림의 평면화
     * - 문자열 요소로 구성된 리스트에서 고유 문자로 이루어진 리스트 반환 예제.
     */
    @Test
    public void steamTest3(){
        List<String> strList = Arrays.asList("Hello", "World");

        /**
         * 우리가 원하는 스트림 형식은 Stream<String> 이나
         * map으로 전달한 람다는 각 단어의 String[] 문자열 배열을 반환하기 때문에
         * 스트림 형식은 Stream<String[]>이 되므로 원하는 고유 문자로 구성된 리스트를 반환받을 수 없다.
         */
        List<String[]> resultList = strList.stream()
                .map(s -> s.split(""))
                .distinct()
                .collect(toList());

        /**
         * flatMap은 각 배열을 스트림이 아니라 스트림의 콘텐츠로 매핑한다.
         * 즉, flatMap 메서드는 스트림의 각 값을 다른 스트림으로 만든 다음에 모든 스트림을 하나의 스트림으로 연결한다.
         * Stream<Stream<String>> -> Stream<String> 과 같이 하나의 스트림으로 연결.
         */
        List<String> uniqueStrList = strList.stream()
                .map(s -> s.split(""))  // 각 단어를 개별 문자를 포함하는 배열로 변환.
                .flatMap(Arrays::stream)    // 생성된 스트림을 하나의 스트림으로 평면화. 즉, Stream<Stream<String>>을 Stream<String>으로 바꾼다.
                .distinct()
                .collect(toList());

        assertEquals(7, uniqueStrList.size());

        /**
         * .flatMap(Arrays::stream)에 대한 부가 설명
         *
         * - map(s -> s.split("")) 에서 split 된 문자열로 구성된 배열이 생성된다. 이때 스트림 형식은 Stream<String[]>이다.
         * - Arrays::stream은 Arrays.stream(배열)의 메서드 레퍼런스로 입력으로 받은 배열을 스트림으로 변환해준다.
         * 이때 스트림 형식은 Stream<Stream<String>>이지만 flatMap 메서드가 스트림을 평면화 해줌으로써 Stream<String>이 된다.
         */
    }

}
