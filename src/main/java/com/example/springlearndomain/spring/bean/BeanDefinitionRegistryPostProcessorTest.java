package com.example.springlearndomain.spring.bean;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import com.example.springlearndomain.aop.anno.RunEnum;
import com.example.springlearndomain.spring.bean.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 15:20
 * @Version: 1.0
 * @Description:
 */
@Slf4j
@Component
@ExecuteTime(RunEnum.CREATE)
public class BeanDefinitionRegistryPostProcessorTest implements BeanDefinitionRegistryPostProcessor {
    //使用场景：你可以在这里动态注册自己的beanDefinition，可以加载classpath之外的bean


    //而BeanDefinitionRegistryPostProcessor是在
    //
    //BeanFactoryPostProcessor的前面执行
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        log.info("BeanDefinitionRegistryPostProcessorTest    postProcessBeanDefinitionRegistry  ------------");
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Person.class);
        beanDefinitionRegistry.registerBeanDefinition("person",rootBeanDefinition);
    }

    //的定义信息已经加载但还没有初始化的时候执行方法
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("BeanDefinitionRegistryPostProcessorTest    postProcessBeanFactory  -------------");
        Object person = configurableListableBeanFactory.getBean("person");
        if (Objects.nonNull(person)){
            Person target = (Person) person;
            String s = target.sayName();
            log.info("name   -> {}",s);
        }
    }
}
