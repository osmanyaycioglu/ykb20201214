package com.training.ykb.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/rest")
public class MyRest {

    @Autowired
    private EmployeeManager em;

    @GetMapping("/hello")
    public String helloGET() {
        return "Hello world GET";
    }

    @PostMapping("/hello")
    public String helloPOST() {
        return "Hello world POST";
    }

    @PutMapping("/hello")
    public String helloPUT() {
        return "Hello world PUT";
    }

    @GetMapping("/hello2/isim/{abc}/soyisim/{xyz}")
    public String hello2(@PathVariable("abc") final String name,
                         @PathVariable("xyz") final String surname) {
        return "Hello 2 : " + name + " " + surname;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("is") final String name,
                         @RequestParam("soy") final String surname) {
        return "Hello 3 : " + name + " " + surname;
    }

    @GetMapping("/hello4/{is}")
    public String hello4(@PathVariable("is") final String name,
                         @RequestParam("soy") final String surname) {
        return "Hello 4 : " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String hello5(@RequestHeader("is") final String name,
                         @RequestHeader("soy") final String surname) {
        return "Hello 5 : " + name + " " + surname;
    }

    @PostMapping("/hello6")
    public String hello6(@RequestBody final Employee emp) {
        return "Hello 6 : " + emp;
    }

    @PostMapping(value = "/hello7",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Employee hello7(@RequestBody final Employee emp) {
        emp.setAge(100);
        return emp;
    }

    @PostMapping("/hello8")
    public String hello8(@Validated @RequestBody final Employee emp,
                         final HttpServletRequest http) {
        //        if (emp.getAge() > 120) {
        //            throw new IllegalArgumentException("age 120 den büyük olamaz");
        //        }
        this.em.addEmployee(emp);
        return "Hello 8 : " + emp;
    }

}

