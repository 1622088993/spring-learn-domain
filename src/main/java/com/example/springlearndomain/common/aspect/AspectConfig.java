package com.example.springlearndomain.common.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 18:02
 * @Version: 1.0
 * @Description:
 */
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class AspectConfig {
    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled", havingValue = "true")
    StarterService starterService() {
        return new StarterService(properties.getUserStr());
    }
}
