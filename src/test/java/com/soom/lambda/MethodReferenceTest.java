package com.soom.lambda;

import com.soom.lambda.domain.Person;
import com.soom.lambda.functional_interface.PersonFunc;
import com.soom.lambda.service.MathUtil;
import com.soom.lambda.service.PersonFactory;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-11.
 */
public class MethodReferenceTest {
    @Test
    public void staticMethodReferenceTest(){
        String sentence = "Hello";
        Function<String, Integer> f1 = String::length;

        assertEquals(5, (int)f1.apply(sentence));
    }

    @Test
    public void plusTwoNumber(){
        IntBinaryOperator operator = (int a, int b) -> MathUtil.plusTwoNumber(a, b);
        assertEquals(9, operator.applyAsInt(3, 6));

        IntBinaryOperator operator1 = (a, b) -> MathUtil.plusTwoNumber(a, b);
        assertEquals(11, operator1.applyAsInt(4,7));

        IntBinaryOperator operator2 = MathUtil::plusTwoNumber;
        assertEquals(15, operator2.applyAsInt(10, 6));
    }

    @Test
    public void multipleTwoNumber(){
        MathUtil mathUtil = new MathUtil();
        IntBinaryOperator operator = (int a, int b) -> mathUtil.multipleTwoNumber(a, b);
        assertEquals(12, operator.applyAsInt(3, 4));

        IntBinaryOperator operator1 = (a, b) -> mathUtil.multipleTwoNumber(a, b);
        assertEquals(15, operator1.applyAsInt(3, 5));

        IntBinaryOperator operator2 = mathUtil::multipleTwoNumber;
        assertEquals(21, operator2.applyAsInt(3, 7));
    }

    @Test
    public void getInstanceTest(){
        Person person = PersonFactory.getInstaance("황곰돌", 10, "hgd1234@gmail.com");
        assertEquals("황곰돌", person.getName());

        PersonFunc personFunc = (String name, int age, String email) -> PersonFactory.getInstaance(name, age, email);
        Person person1 = personFunc.apply("김곰돌", 12, "abc@naver.com");
        assertEquals(12, person1.getAge());

        PersonFunc personFunc1 = (name, age, email) -> PersonFactory.getInstaance(name, age, email);
        Person person2 = personFunc1.apply("최곰돌", 20, "eee@naver.com");
        assertEquals("eee@naver.com", person2.getEmail());

        PersonFunc personFunc2 = PersonFactory::getInstaance;
        Person person3 = personFunc2.apply("윤곰돌", 13, "ccc@naver.com");
        assertEquals(13, person3.getAge());
    }

}
