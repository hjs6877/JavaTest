package com.soom.enumtest;

public enum PayType {
    ACCOUNT_TRANSFER("계좌 이체"),
    ON_SITE_PAYMENT("현장 결제"),
    TOSS("토스"),
    PAYCO("페이코"),
    CARD("신용카드"),
    KEVIN_PAY("케빈 페이"),
    POINT("포인트"),
    COUPON("쿠폰");

    private String title;

    PayType(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
}
