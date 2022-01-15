package com.example.springlearndomain.strategy.execute;

import com.google.common.collect.Maps;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/12 23:43
 * @Version: 1.0
 * @Description:
 */
@Component
@Getter
public class CommandFactory implements InitializingBean, ApplicationContextAware {


    public static final Map<String,InnerCommand> map= Maps.newHashMap();

    private ApplicationContext appContext;
    @Override
    public void afterPropertiesSet() throws Exception {
        appContext.getBeansOfType(InnerCommand.class).values().forEach(command->map.put(command.getType(),command));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }
}
