package com.example.springlearndomain.aop.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface Check {

    int[] num() default {1,2};


    Class[] targetClass();
}
