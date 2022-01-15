package com.example.springlearndomain.bean.post.process.anno;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 0:25
 * @Version: 1.0
 * @Description:
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RoutingInjected{
}