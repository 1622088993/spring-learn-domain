package com.example.springlearndomain.common.aspect.util;

import com.example.springlearndomain.common.aspect.StarterService;
import com.example.springlearndomain.common.aspect.annotation.DoDoor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 22:46
 * @Version: 1.0
 * @Description:
 */

@Aspect
@Component
public class DoJsonPoint {

    @Autowired
    private StarterService starterService;


    @Pointcut("@annotation(com.example.springlearndomain.common.aspect.annotation.DoDoor)")
    private void doDoor(){};
    @Around("doDoor()")
    public Object doRoute(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        Method method = getMethod(proceedingJoinPoint);
        DoDoor annotation = method.getAnnotation(DoDoor.class);
        String key = annotation.key();
        String s = annotation.returnJson();
        return null;

    }

    private Method getMethod(ProceedingJoinPoint proceedingJoinPoint) throws NoSuchMethodException {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
       return getClass(proceedingJoinPoint).getMethod(signature.getName(),signature.getParameterTypes());
    }


    private Class<? extends Object> getClass(ProceedingJoinPoint proceedingJoinPoint){
        return proceedingJoinPoint.getTarget().getClass();
    }
}
