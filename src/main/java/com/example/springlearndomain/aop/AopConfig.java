package com.example.springlearndomain.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/22 23:34
 * @Version: 1.0
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AopConfig {

    @Pointcut("execution(* com.example.springlearndomain.Service.service..*.*(..))")
    public void userDapAop(){}

    @Pointcut("execution(* com.example.springlearndomain..*.save*(..))")
    public void save(){}


    @Around("userDapAop()")
    public void aopTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aop ");
        proceedingJoinPoint.proceed();
    }


    @SneakyThrows
    @Around("save()")
    public void saveAop(ProceedingJoinPoint proceedingJoinPoint){
        log.info("AOP    all save  method");
        proceedingJoinPoint.proceed();
    }


}
