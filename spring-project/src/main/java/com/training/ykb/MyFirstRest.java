package com.training.ykb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@Repository
//@Service
//@Configuration

@RestController
@RequestMapping("/test")
public class MyFirstRest {

    @GetMapping
    public String hello() {
        return "Hello world";
    }
}
