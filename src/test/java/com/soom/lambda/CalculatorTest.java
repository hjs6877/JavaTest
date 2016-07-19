package com.soom.lambda;

import com.soom.lambda.functional_interface.Calculator;
import org.junit.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-14.
 */
public class CalculatorTest {
    @Test
    public void calcTest1(){
        Calculator calculator = (int a, int b) -> a + b;
        assertEquals(11, calculator.calc(5, 6));
    }

    @Test
    public void calcTest2(){
        Calculator calculator = (int a, int b) -> {
            int c = 5;
            return a + b + c;
        };
        assertEquals(16, calculator.calc(5, 6));
    }

    @Test
    public void calcTest3(){
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
        assertEquals(11, intBinaryOperator.applyAsInt(5, 6));
    }
}
