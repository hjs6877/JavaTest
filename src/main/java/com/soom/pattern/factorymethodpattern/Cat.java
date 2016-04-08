package com.soom.pattern.factorymethodpattern;

/**
 * Created by kjs on 2016-04-06.
 */
public class Cat extends Animal {

    @Override
    AnimalToy getToy() {
        return new CatToy();
    }
}
