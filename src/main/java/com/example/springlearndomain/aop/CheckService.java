package com.example.springlearndomain.aop;

import com.example.springlearndomain.aop.annoation.Check;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/11/7 13:49
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CheckService {


    @Check(targetClass = {CheckService.class})
    public void checkNum(String name,Integer num){
        log.info("checkNum      name {}   num {}",name,num);
    }


    public void save(){
        log.info("save -----");
    }
}
