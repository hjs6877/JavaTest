package com.soom.pattern.factorymethodpattern;

/**
 * 팩터리 메서드가 생성할 객체
 */
public class DogToy extends AnimalToy {
    @Override
    void identify() {
        System.out.println("나는 테니스 공. 강아지 장난감!");
    }
}
