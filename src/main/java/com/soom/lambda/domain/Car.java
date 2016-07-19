package com.soom.lambda.domain;

/**
 * Created by kjs on 2016-07-14.
 */
public class Car {
    private String carName;
    private String type;
    private int cc;
    private String color;
    private long price;

    public Car(String carName, String type, int cc, String color, int price) {
        this.carName = carName;
        this.type = type;
        this.cc = cc;
        this.color = color;
        this.price = price;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
