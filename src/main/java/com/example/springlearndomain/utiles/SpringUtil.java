package com.example.springlearndomain.utiles;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 21:57
 * @Version: 1.0
 * @Description:
 */
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    public static <T> T getBean(String beanName) {
        if(applicationContext.containsBean(beanName)){
            return (T) applicationContext.getBean(beanName);
        }else{
            return null;
        }
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> baseType){
        return applicationContext.getBeansOfType(baseType);
    }


    public static <T> T getBeanByClass(Class<T> beanClass){
        return applicationContext.getBean(beanClass);
    }
}
