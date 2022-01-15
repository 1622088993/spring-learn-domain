package com.example.springlearndomain.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 12:27
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
@Order(2)
public class CmdFactory implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
            log.info("ConfigurableApplicationContext initialize");

            // 打印容器里面有多少个bean
            System.out.println("bean count=====" + applicationContext.getBeanDefinitionCount());

            // 打印人所有 beanName
            System.out.println(applicationContext.getBeanDefinitionCount() + "个Bean的名字如下：");
            String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                System.out.println(beanName);
            }

    }
}
