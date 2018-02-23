package com.soom.enumtest;

import org.junit.Test;

import java.util.Arrays;

public class PayGroupTest {
    @Test
    public void getPayGroupValuesTet(){
        PayGroup[] payGroups = PayGroup.values();
        Arrays.stream(payGroups)
                .forEach(payGroup -> System.out.println(payGroup.name()));
    }

    @Test
    public void getPayCodeTest(){
        PayGroup payGroup = PayGroup.findByPayCode(PayType.ACCOUNT_TRANSFER);
        System.out.println(payGroup.name());
        System.out.println(payGroup.getTitle());
    }
}
