package com.example.springlearndomain.type;

import com.example.springlearndomain.aop.annoation.Check;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/11/7 13:49
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
public class CheckServiceMethod {


    @Check(targetClass = {CheckServiceMethod.class})
    public void checkNum(String name,Integer num){
        log.info("checkNum      name {}   num {}",name,num);
    }


    public void saveUser(){
        log.info("CheckServiceMethod save -----");
    }
}
