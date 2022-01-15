package com.example.springlearndomain.spring;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 14:36
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
@Order(1)
public class FirstInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        //获取applicationcontext 启动的时候的参数
        log.info("FirstInitializer start------------------------------");
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        log.info("systemEnvironment  {}", JSON.toJSON(systemEnvironment));
    }
}
