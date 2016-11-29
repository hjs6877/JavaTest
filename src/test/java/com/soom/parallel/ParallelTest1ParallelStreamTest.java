package com.soom.parallel;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-27.
 */
public class ParallelTest1ParallelStreamTest {
    @Test
    public void parallelStreamTest1(){
        long result = this.sequentialSum(10);
        assertEquals(55, result);
    }

    private long sequentialSum(int n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }
}
