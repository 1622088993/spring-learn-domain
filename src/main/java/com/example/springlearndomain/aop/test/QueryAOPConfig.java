package com.example.springlearndomain.aop.test;

import com.example.springlearndomain.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/12 13:14
 * @Version: 1.0F
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class QueryAOPConfig {

    @Pointcut("execution(* com.example.springlearndomain.aop.query..*.*(..))")
    public void queryPoint(){};

    @Around("queryPoint()")
    public Object queryAOPSection(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("method name {}",method.getName());
        // 计算唯一的md5
        Object[] args = proceedingJoinPoint.getArgs();
        String s = generateMd5ByArgs(args);
        Object resultDTO = proceedingJoinPoint.proceed(args);
        if (resultDTO instanceof PersonDTO){
            Class<?> personDTOClass = resultDTO.getClass();
            Field[] declaredFields = personDTOClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.getName().equals("name")){
                    declaredField.setAccessible(true);
                    declaredField.set(resultDTO,"ylj");
                }
                if (declaredField.getName().equals("age")){
                    declaredField.setAccessible(true);
                    declaredField.set(resultDTO,22);
                }
            }
        }

        return resultDTO;
    }

    private String generateMd5ByArgs(Object[] args) {
        StringBuffer encryptString=new StringBuffer();
        for (Object arg : args) {
            encryptString.append(arg.toString());
        }
        String s = DigestUtils.md5DigestAsHex(encryptString.toString().getBytes(StandardCharsets.UTF_8));
        log.info("generateMd5ByArgs  md5 arg {}   result {}",args,s);
        return s;
    }


}
