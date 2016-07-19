package com.soom.lambda.comparator;

import com.soom.lambda.domain.Apple;

import java.util.Comparator;

/**
 * Created by kjs on 2016-07-11.
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight() < o2.getWeight() ? -1 :(o1.getWeight() > o2.getWeight() ? 1 : 0);
    }
}
