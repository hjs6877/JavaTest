package com.soom.lambda.domain;

import java.time.LocalDate;

/**
 * Created by kjs on 2016-07-14.
 */
public class Employee {
    private String name;
    private LocalDate birthday;
    private Gender gender;
    private int age;

    public enum Gender {
        MALE, FEMALE
    }

    public Employee(String name, LocalDate birthday, Gender gender, int age) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
