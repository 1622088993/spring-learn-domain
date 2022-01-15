package com.example.springlearndomain.aop.method;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/5 11:31
 * @Version: 1.0
 * @Description:
 */

// 表示方法级别的拦截器
@Slf4j
public class QueryMethodInterceptor implements MethodInterceptor {

    @Nullable
    @Override
    public Object invoke(@Nonnull MethodInvocation methodInvocation) throws Throwable {
        log.info("QueryMethodInterceptor MethodInvocation  {}   method name {} ", JSON.toJSONString(methodInvocation),methodInvocation.getMethod().getName());
        return methodInvocation.proceed();
    }
}
