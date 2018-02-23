package com.soom.enumtest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumMapperTypeTest {
    @Test
    public void enumMapperTypeTest() {
        List<EnumMapperValue> enumMapperValueList = Arrays.stream(FeeType.values())
                .map(feeType -> new EnumMapperValue(feeType))
                .collect(Collectors.toList());

        System.out.println(enumMapperValueList);
    }
}
