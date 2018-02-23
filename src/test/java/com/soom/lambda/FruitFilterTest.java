package com.soom.lambda;

import com.soom.lambda.domain.Apple;
import com.soom.lambda.predicate.AppleGreenColorPredicate;
import com.soom.lambda.predicate.AppleHeavyWeightPredicate;
import com.soom.lambda.predicate.ApplePredicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * summary:
 * <p> description:
 * <p><b>History:</b>
 * - 작성자, 2017-08-31 최초 작성<br/>
 *
 * @author Kevin
 * @see
 */
public class FruitFilterTest {
    @Test
    public void filterFruit01() {
        List appleList = Arrays.asList(new Apple(100, "green"), new Apple(200, "red"));
        List<Apple> result1 = filterGreenApples(appleList);
        List<Apple> result2 = filterApplesByColor(appleList, "red");

        assertThat(result1.get(0).getColor(), is(equalTo("green")));
        assertThat(result2.get(0).getColor(), is(equalTo("red")));

    }

    @Test
    public void filterFruit02() {
        List<Apple> appleList = Arrays.asList(new Apple(100, "green"), new Apple(200, "red"));

        List<Apple> result = filterGreenApplesByPredicateGreenColor(appleList, new AppleGreenColorPredicate());

        assertThat(result.get(0).getColor(), is(equalTo("green")));

    }

    @Test
    public void filterFruit03(){
        List<Apple> appleList = Arrays.asList(new Apple(100, "green"), new Apple(200, "red"));
        List<Apple> result = filterApplesByPredicateHeavyWeight(appleList, new AppleHeavyWeightPredicate());

        assertThat(result.get(0).getWeight(), is(greaterThan(150)));
    }

    private List<Apple> filterApplesByPredicateHeavyWeight(List<Apple> appleList,
                                                           AppleHeavyWeightPredicate p) {
        List result = new ArrayList<>();

        for(Apple apple : appleList){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    private List<Apple> filterGreenApplesByPredicateGreenColor(List<Apple> appleList, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : appleList){
            if(p.test(apple)){
                result.add(apple);
            }
        }

        return result;

    }

    private List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : apples){
            if(apple.getColor().equals("green")){
                result.add(apple);
            }
        }
        return result;
    }

    private List<Apple> filterApplesByColor(List<Apple> inventory, String color){
        List<Apple> result = new ArrayList();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }

        return result;
    }
}
