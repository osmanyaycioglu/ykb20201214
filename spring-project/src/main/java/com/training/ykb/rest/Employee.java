package com.training.ykb.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.rest.validation.StartWith;

@XmlRootElement
public class Employee {

    @NotEmpty
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String name;

    @StartWith("soy")
    private String surname;

    @Max(value = 120, message = "age 120 den büyük olamaz")
    private int    age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Employee [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }


}
