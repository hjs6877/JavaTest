package com.soom.lambda.service;

import com.soom.lambda.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by kjs on 2016-07-14.
 */
public class EmployeeFinder {
    public static List<Employee> findEmployeesOlderThan(List<Employee> employeeList, int age){
        List<Employee> filteredEmployeeList = new ArrayList<>();

        for(Employee employee : employeeList){
            if(employee.getAge() >= age){
                filteredEmployeeList.add(employee);
            }
        }
        return filteredEmployeeList;
    }

    public static List<Employee> findEmployeesWithinAgeRange(List<Employee> employeeList, Predicate<Employee> p){
        List<Employee> filteredEmployeeList = new ArrayList<>();

        for(Employee employee : employeeList){
            if(p.test(employee)){
                filteredEmployeeList.add(employee);
            }
        }

        return filteredEmployeeList;
    }
}
