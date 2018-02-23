package com.soom.enumtest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum PayGroup {
    CASH("현금", Arrays.asList(PayType.ACCOUNT_TRANSFER, PayType.ON_SITE_PAYMENT, PayType.TOSS)),
    CARD("카드", Arrays.asList(PayType.PAYCO, PayType.CARD, PayType.KEVIN_PAY)),
    ETC("기타", Arrays.asList(PayType.POINT, PayType.COUPON)),
    EMPTY("없음", Collections.EMPTY_LIST);

    private String title;
    private List<PayType> payList;

    PayGroup(String title, List<PayType> payList) {
        this.title = title;
        this.payList = payList;
    }

    public String getTitle(){
        return title;
    }

    public static PayGroup findByPayCode(PayType payType){
        return Arrays.stream(PayGroup.values())
                .filter(payGroup -> payGroup.hasPayCode(payType))
                .findAny()
                .orElse(EMPTY);
    }

    private boolean hasPayCode(PayType payType) {
        return payList.stream()
                .anyMatch(pay -> pay == payType);
    }
}
