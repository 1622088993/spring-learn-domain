package com.example.springlearndomain.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 23:26
 * @Version: 1.0
 * @Description:
 */
@Configuration
public  class AbstractLookService implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("nsq.enable");
        if (StringUtils.isEmpty(property)){
            return false;
        }
        return Boolean.parseBoolean(property);
    }
}
