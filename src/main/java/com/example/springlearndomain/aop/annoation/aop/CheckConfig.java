package com.example.springlearndomain.aop.annoation.aop;

import com.alibaba.fastjson.JSON;
import com.example.springlearndomain.aop.CheckService;
import com.example.springlearndomain.aop.annoation.Check;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * @Author: YangLiJun
 * @Date: 2021/11/7 13:24
 * @Version: 1.0
 * @Description:
 */

@Component
@Aspect
@Slf4j
public class CheckConfig {

    @Pointcut("@annotation(com.example.springlearndomain.aop.annoation.Check)")
    public void checkPointcut(){};


    @Around("checkPointcut()")
    public void checkAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("get arg  ------         -----");
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            log.info("argos  {}   ", JSON.toJSONString(arg));
        }
        log.info("get target  ----             ----");
        Object target = proceedingJoinPoint.getTarget();

        log.info("target   class {}",target.getClass());



        log.info("signature         ---------- ------ ---");
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("method     --------------");
        Check annotation = method.getAnnotation(Check.class);
        log.info("annoation    {}    {}",annotation.num(),annotation.targetClass());
        args[0]="ttmp";
        proceedingJoinPoint.proceed(args);
    }

}
