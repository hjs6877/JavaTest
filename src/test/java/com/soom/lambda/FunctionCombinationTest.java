package com.soom.lambda;

import org.junit.Test;

import java.util.function.Function;
import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-11.
 */
public class FunctionCombinationTest {
    @Test
    public void functionAndThenTest(){
        /**
         * andThen 메서드는 주어진 함수를 먼저 적용한 결과를 다른 함수의 입력으로 전달하는 함수를 반환한다.
         * - g(f(x))
         * - f1의 결과를 f2의 입력으로 전달한다.
         */
        Function<Integer, Integer> f1 = num -> num + 1;
        Function<Integer, Integer> f2 = num -> num * 2;
        Function<Integer, Integer> f3 = f1.andThen(f2);
        int result = f3.apply(2);

        assertEquals(6, result);
    }

    @Test
    public void functionCompose(){
        /**
         * compose 메서드는 인수로 주어진 함수를 먼저 실행한 다음에 그 결과를 외부 함수의 인수로 제공한다.
         * - f(g(x))
         * - f2의 결과를 f1의 입력으로 전달한다.
         */
        Function<Integer, Integer> f1 = x -> x + 1;
        Function<Integer, Integer> f2 = x -> x * 2;
        Function<Integer, Integer> f3 = f1.compose(f2);
        int result = f3.apply(2);

        assertEquals(5, result);
    }
}
