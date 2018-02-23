package com.soom.enumtest;

public enum  FeeType implements EnumMapperType {
    PERCENT("퍼센트"),
    MONEY("머니");

    private String title;

    FeeType(String title) {
        this.title = title;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
