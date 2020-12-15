package com.training.ykb.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyUsingBean {

    @Autowired
    @Qualifier("ali")
    private MyFirstBean       firstBean;

    private final MyFirstBean constructorInjectedFirstBean;

    private MyFirstBean       methodInjectedFirstBean;

    @Autowired
    public MyUsingBean(@Qualifier("veli") final MyFirstBean constructorInjectedFirstBean) {
        System.out.println("constructor");
        this.constructorInjectedFirstBean = constructorInjectedFirstBean;
        constructorInjectedFirstBean.hello();
    }

    @Autowired
    @Qualifier("ali")
    public void methodInjection(final MyFirstBean methodInjectedFirstBean) {
        System.out.println("method injection");
        this.methodInjectedFirstBean = methodInjectedFirstBean;
    }

    @PostConstruct
    public void initBean() {
        System.out.println("post construct");
    }

    @PreDestroy
    public void destroyBean() {
        System.out.println("pre destroy");
    }


    public String exec() {
        return "Executed : " + this.firstBean.hello();
    }

}
