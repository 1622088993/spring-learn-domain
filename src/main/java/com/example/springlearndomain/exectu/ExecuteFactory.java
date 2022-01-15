package com.example.springlearndomain.exectu;

import com.google.common.collect.ArrayListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/5 10:39
 * @Version: 1.0
 * @Description:
 */


@Slf4j
@Component(value = "executeFactoryF")
public class ExecuteFactory implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Map<String, AspExecute> aspExecuteMap = applicationContext.getBeansOfType(AspExecute.class);
        for (Map.Entry<String, AspExecute> stringAspExecuteEntry : aspExecuteMap.entrySet()) {
            log.info("ExecuteFactory  get abstract impl   name {}   execute {}",stringAspExecuteEntry.getKey(),stringAspExecuteEntry.getValue());
        }
    }
}
