package com.soom.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by kjs on 2016-07-15.
 */
public class ArraysStreamTest {
    @Test
    public void flatMapTest(){
        List<String> words = Arrays.asList("Hello", "World");

        /*
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);     // 배열을 문자열 스트림으로 변환.
        */
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        for(String ch : uniqueCharacters){
            System.out.println(ch);
        }
    }

    @Test
    public void mapTest(){
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squareNumList = numList.stream()
                .map(num -> num * num)
                .collect(toList());
        for(int num : squareNumList){
            System.out.println(num);
        }
    }

    /**
     * 두개의 숫자 리스트가 있을때 모든 숫자 쌍의 리스트를 반환.
     * (1,3), (1,4), (2,3), (2, 4), (3,3), (3,4)
     */
    @Test
    public void flatMapTest2(){
        List<Integer> numList1 = Arrays.asList(1, 2, 3);
        List<Integer> numList2 = Arrays.asList(3, 4);

        List<int[]> pairs = numList1.stream()
                .flatMap(i -> numList2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(toList());
    }

    /**
     * 두개의 숫자 리스트가 있을때 모든 숫자 쌍의 리스트 중에서 합이 3으로 나누어 떨어지는 쌍만 반환
     * (1,3), (1,4), (2,3), (2, 4), (3,3), (3,4)
     */
    @Test
    public void flatMapTest3(){
        List<Integer> numList1 = Arrays.asList(1, 2, 3);
        List<Integer> numList2 = Arrays.asList(3, 4);

        List<int[]> pairs = numList1.stream()
                .flatMap(i -> numList2.stream()
                        .filter(j -> (i+j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(toList());
    }
}
