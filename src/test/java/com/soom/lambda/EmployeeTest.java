package com.soom.lambda;

import com.soom.lambda.domain.Employee;
import com.soom.lambda.service.EmployeeFinder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by kjs on 2016-07-14.
 */
public class EmployeeTest {
    private static List<Employee> employeeList;

    @BeforeClass
    public static void beforeClass(){
        employeeList = Arrays.asList(
                new Employee("김곰돌", LocalDate.of(1980, 4, 6), Employee.Gender.MALE, 35),
                new Employee("이곰돌", LocalDate.of(1975, 5, 16), Employee.Gender.FEMALE, 40),
                new Employee("박곰돌", LocalDate.of(2000, 12, 26), Employee.Gender.FEMALE, 15),
                new Employee("황곰돌", LocalDate.of(1999, 10, 4), Employee.Gender.MALE, 16),
                new Employee("최곰돌", LocalDate.of(2001, 2, 21), Employee.Gender.MALE, 14)
        );
    }

    @Test
    public void findeOlderThanTest(){
        assertEquals(2, EmployeeFinder.findEmployeesOlderThan(employeeList, 30).size());
    }

    @Test
    public void findEmployeeWithinAgeRangeTest(){
        List<Employee> resultList = EmployeeFinder.findEmployeesWithinAgeRange(
                employeeList,
                (Employee employee) -> employee.getAge() >= 15
                );
        assertEquals(4, resultList.size());
    }
}
