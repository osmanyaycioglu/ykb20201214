package com.training.ykb.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("veli")
// @Scope("prototype")
public class MyFirstBean {

    public String hello() {
        return "Hello from spring bean";
    }

}
