package com.training.ykb.rest.design;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Employee;

@RestController
@RequestMapping("/employee1/search")
public class EmployeeSearchDesign1 {

    @GetMapping
    public List<Employee> getAllEmployee() {
        return null;
    }


}
