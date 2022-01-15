package com.example.springlearndomain.aop.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/30 22:47
 * @Version: 1.0
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteTime {

    RunEnum[] value();
}
