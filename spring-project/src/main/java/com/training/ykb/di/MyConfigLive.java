package com.training.ykb.di;

import org.springframework.context.annotation.Bean;

//@Configuration
//@Profile("live")
public class MyConfigLive {

    @Bean
    public MyFirstBean createMyFirst() {
        MyFirstBean myFirstBeanLoc = new MyFirstBean();

        return myFirstBeanLoc;
    }

}
