package com.soom.lambda;

import com.soom.lambda.domain.Car;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-14.
 */
public class LamdaExampleTest {
    private static List<Car> carList;

    @BeforeClass
    public static void beforeClass(){
        carList = Arrays.asList(
                new Car("올란도", "SUV", 1800, "GRAY", 28000000),
                new Car("말리부", "세단", 1500, "YELLOW", 23000000),
                new Car("트랙스", "SUV", 1700, "WHITE", 22000000),
                new Car("캡티바", "SUV", 2000, "BLACK", 32000000),
                new Car("임팔라", "세단", 2000, "GREEN", 35000000)
        );
    }

    /**
     * 자동차 cc로 필터링 한 list 반환 예제.
     */
    @Test
    public void filterCarListTest(){
        List<Car> filteredCarList1 = this.filterCarList(carList, (Car car) -> car.getCc() >= 2000);
        List<Car> filteredCarList2 = this.filterCarList(carList, (car) -> car.getCc() >= 1800);

        assertEquals(2, filteredCarList1.size());
        assertEquals(3, filteredCarList2.size());

    }

    private List<Car> filterCarList(List<Car> carList, Predicate<Car> p){
        List<Car> filteredCarList = new ArrayList<>();

        for(Car car : carList){
            if(p.test(car)){
                filteredCarList.add(car);
            }

        }

        return filteredCarList;
    }
}
