package com.example.springlearndomain.aop.advanced;

import com.google.common.base.CharMatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/12 14:46
 * @Version: 1.0
 * @Description:
 */

@Component
@Slf4j
public class CommonQueryConfig implements BeanPostProcessor, ApplicationEventPublisherAware, ApplicationContextAware {

    //于该Spring IOC容器所创建的每个bean实例在初始化方法（如afterPropertiesSet和任意已声明的init方法）调用前，
    // 将会调用BeanPostProcessor中的postProcessBeforeInitialization方法，而在bean实例初始化方法调用完成后
    // 则会调用BeanPostProcessor中的postProcessAfterInitialization方法，整个调用顺序可以简单示意如下


    @PostConstruct
    public void init(){

    }


    private ApplicationEventPublisher applicationEventPublisher;
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = bean.getClass();
        String simpleName = targetClass.getSimpleName();
        log.info("simpleName  is {}",simpleName);
        if (!matchStringByRegularExpression(simpleName,"CommonQuery")){
            return bean;
        }
        for (Method method : targetClass.getMethods()) {
            if (matchStringByRegularExpression("queryPersonByIdAnsSave",method.getName())){
                log.info("simpleName  is {}");
                CommonQueryConfigProxyFactory commonQueryConfigProxyFactory = CommonQueryConfigProxyFactory.of(applicationEventPublisher, applicationContext);

                return commonQueryConfigProxyFactory.createProxy(bean);
            }
        }
        return bean;
    }

    private Boolean matchStringByRegularExpression(String parent, String child) {
        Pattern p = Pattern.compile(child);
        Matcher m = p.matcher(parent);
        return m.find();
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
