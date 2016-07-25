package com.soom.stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * 앞선 예제에서는 컬렉션에서 스트림을 얻고, 범위의 숫자에서 스트림을 만드는 방법을 살펴 보았다.
 * 이밖에도 일련의 값, 배열, 파일, 함수를 이용한 무한 스트림 만들기 등 다양한 방식으로 스트림을
 * 만들 수 있다.
 */
public class StreamTest9MakeStreamTest {
    @Test
    public void valueStreamTest(){
        /**
         * 값으로 스트림 생성 예
         * - Stream.of()를 이용해서 스트림을 만들 수 있다.
         */
        Stream<String> stream = Stream.of("Java 8 ", "Lamdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::print);

        /**
         * Stream.empty()를 이용해서 빈 스트림을 만들 수 있다.
         */
        Stream<String> emptyStream = Stream.empty();
    }

    @Test
    public void arrayStreamTest(){
        /**
         * 배열로 스트림 생성
         */
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        assertEquals(41, sum);
    }

    @Test
    public void fileStreamTest(){
        /**
         * 파일로 스트림을 생성하여 파일에서 고유한 단어 수를 찾는 프로그램을 만듬.
         */
        String filePath = "F:\\3_private_project\\1_project\\4_test\\7_JavaTest\\JavaTest\\src\\test\\java\\com\\soom\\stream\\data.txt";
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get(filePath), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            assertEquals(7, uniqueWords);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * - Files.lines()는 주어진 파일의 행 스트림을 문자열로 반환한다.
         * - flatMap()으로 split된 문자열 배열 스트림을 평면화 하여 Stream<String>을 반환한다.
         */
    }

    /**
     * - 스트림 API는 함수에서 스트림을 만들 수 있는 두 개의 정적 메서드 Stream.iterate와 Stream.generate를 제공한다.
     * - 두 메서드를 이용해서 무한 스트림, 즉 고정된 컬렉션에서 고정된 크기의 스트림을 만들었던 것과는 달리
     * 크기가 고정되지 않은 스트림을 만들 수 있다.
     */
    @Test
    public void FunctionStreamTest1(){
        /**
         * 일반적으로 연속된 일련의 값을 만들 때는 iterate()를 사용한다.
         */
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }

    @Test
    public void FunctionStreamTest2(){
        /**
         * iterate()를 이용한 피보나치 수열 예제1
         */
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
    }

    @Test
    public void FunctionStreamTest3(){
        /**
         * iterate()를 이용한 피보나치 수열 예제2
         */
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    @Test
    public void FunctionStreamTest4(){
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
