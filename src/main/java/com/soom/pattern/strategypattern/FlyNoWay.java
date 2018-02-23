package com.soom.pattern.strategypattern;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-03-23 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("날지 못합니다!");
    }
}
