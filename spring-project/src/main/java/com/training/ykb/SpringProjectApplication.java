package com.training.ykb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.training.ykb.di.MyUsingBean;

import a.b.c.BeanA;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.ykb",
//                                            "a.b.c"
//})
@SpringBootApplication
public class SpringProjectApplication {

    @Autowired
    private BeanA beanwire;

    public static void main(final String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class,
                                                                       args);
        MyUsingBean beanLoc = context.getBean(MyUsingBean.class);
        System.out.println(beanLoc.exec());

        //        MyUsingBean beanLoc = new MyUsingBean();
        //        beanLoc.exec();

    }

}
