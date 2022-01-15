package com.example.springlearndomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = {"com.example.springlearndomain"})
@EnableCaching
@EnableAspectJAutoProxy

public class SpringLearnDomainApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringLearnDomainApplication.class, args);
    }

}
