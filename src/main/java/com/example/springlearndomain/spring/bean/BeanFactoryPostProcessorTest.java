package com.example.springlearndomain.spring.bean;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import com.example.springlearndomain.aop.anno.RunEnum;
import com.example.springlearndomain.spring.bean.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 15:36
 * @Version: 1.0
 * @Description:
 */
@Component
@ExecuteTime(RunEnum.CREATE)
@Slf4j
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    //一个是针对BeanDefinition的容器级别的后处理器
    //处理完所有的bean前，对bean factory 进行预处理
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition person = configurableListableBeanFactory.getBeanDefinition("person");
    }
}
