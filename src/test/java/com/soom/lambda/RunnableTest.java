package com.soom.lambda;

import org.junit.Test;

/**
 * Created by kjs on 2016-03-08.
 */
public class RunnableTest {
    @Test
    public void runnableToLambdaTest(){
        Runnable r = () -> System.out.println("create Runnable object!");
        r.run();
    }
}
