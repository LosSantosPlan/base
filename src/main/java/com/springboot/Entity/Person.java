package com.springboot.Entity;

import lombok.Data;



/**
 * @author 23696
 */
@Data
public class Person {
    private String name;
    private int age;
    private int salary;
    public Person(){

    }
    public Person(String name,int age,int salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }
}
