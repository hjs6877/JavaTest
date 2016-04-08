package com.soom.pattern.factorymethodpattern;

/**
 * 팩터리 메서드가 생성할 객체
 */
public class CatToy extends AnimalToy{
    @Override
    void identify() {
        System.out.println("나는 캣타워! 고양이 장난감!");
    }
}
