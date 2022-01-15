package com.example.springlearndomain.condition.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 21:45
 * @Version: 1.0
 * @Description:
 */

@Component
public class BoeConfig implements Condition {


    @Value("${yang.isWork:false}")
    private Boolean isWork;

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        return false;
    }
}
