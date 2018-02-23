package com.soom.lambda.predicate;

import com.soom.lambda.domain.Apple;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-08-31 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
