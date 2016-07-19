package com.soom.stream;

import com.soom.lambda.domain.Trader;
import com.soom.lambda.domain.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-18.
 */
public class StreamTest4 {
    private static List<Transaction> transactionList;

    @BeforeClass
    public static void beforeClass(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    @Test
    public void streamTest1(){
        /**
         * 2011년에 일어날 모든 트랜잭션을 찾아 값을 오름차순으로 정렬하시오.
         */
        List<Transaction> resultList =
                transactionList.stream()
                                .filter(t -> t.getYear() == 2011)
                                .sorted(comparing(Transaction::getValue))
                                .collect(toList());
        assertEquals(2, resultList.size());
        assertEquals(300, resultList.get(0).getValue());
        assertEquals(400, resultList.get(1).getValue());
    }

    @Test
    public void streamTest2(){
        /**
         * 거래자가 근무하는 모든 도시를 중복 없이 나열하시오.
         */
        List<String> resultList =
                transactionList.stream()
                                .map(t -> t.getTrader().getCity())
                                .distinct()
                                .collect(toList());
        assertEquals(2, resultList.size());
        assertEquals("Cambridge", resultList.get(0));
        assertEquals("Milan", resultList.get(1));

        for(String city : resultList){
            System.out.println(city);
        }
    }

    @Test
    public void streamTest3(){
        /**
         * 켐브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하시오.
         */
        List<Trader> resultList =
                transactionList.stream()
                                .map(Transaction::getTrader)
                                .filter(trader -> trader.getCity().equals("Cambridge"))
                                .distinct()
                                .sorted(comparing(Trader::getName))
                                .collect(toList());

        for(Trader trader : resultList){
            System.out.println(trader.getName());
        }
    }

    @Test
    public void streamTest4(){
        /**
         * 모든 거래자의 이름을 알파벳순으로 정렬해서 하나의 문자열로 연결하여 반환하시오.
         */
        String result = transactionList.stream()
                .map(transaction -> transaction.getTrader())
                .sorted(comparing(Trader::getName))
                .distinct()
                .map(trader -> trader.getName())
                .reduce("", (s1, s2) -> s1 + " " + s2);

        System.out.println(result);
    }

    @Test
    public void streamTest5(){
        /**
         * 밀라노에 거래자가 있는지 확인하시오.
         */
        boolean result = transactionList.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        assertEquals(true, result);
    }

    @Test
    public void streamTest6(){
        /**
         * 캠브리지에 거주하는 거래자의 모든 트랜잭션 값을 출력하시오.
         * - 캠브리지에 거주하는 거래자만 필터링
         * - 트랜잭션 값을 추출
         * - 출력
         */
        transactionList.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    @Test
    public void streamTest7(){
        /**
         * 전체 트랜잭션 중에서 최대값은 얼마인가?
         * - 전체 트랜잭션 값을 추출한다.
         * - 최대값을 리듀스한다.
         */
        Optional<Integer> integerOptional = transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        assertEquals(1000, (int) integerOptional.get());
    }

    @Test
    public void streamTest8(){
        /**
         * 전체 트랜잭션 중에서 최소값은 얼마인가?
         * - 전체 트랜잭션 값을 추출한다.
         * - 최소값을 리듀스한다.
         */
        Optional<Integer> optionalMin = transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::min);

        assertEquals(300, (int)optionalMin.get());

    }
}
