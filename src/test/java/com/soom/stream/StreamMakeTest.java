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
 * Created by kjs on 2016-07-19.
 */
public class StreamMakeTest {
    @Test
    public void valueStreamTest(){
        /**
         * 값으로 스트림 생성 예
         */
        Stream<String> stream = Stream.of("Java 8 ", "Lamdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::print);
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
         * 파일로 스트림 생성하여 파일에서 고유한 단어 수를 찾는 프로그램을 만듬.
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
    }

    @Test
    public void FunctionStreamTest1(){
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
