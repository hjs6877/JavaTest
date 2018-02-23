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
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<<< 조용~~ >>>");
    }
}
