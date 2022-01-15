package com.example.springlearndomain.cqrs;

import com.example.springlearndomain.strategy.execute.InnerCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/11/7 15:38
 * @Version: 1.0
 * @Description:
 */

@Component
@Slf4j
public class ExecuteFactory implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        Map<String, InnerCommand> innerCommandMap = applicationContext.getBeansOfType(InnerCommand.class);

        for (Map.Entry<String, InnerCommand> stringInnerCommandEntry : innerCommandMap.entrySet()) {
            InnerCommand innerCommand = stringInnerCommandEntry.getValue();
            String type = innerCommand.getType();
            log.info("innerCommand {}  type {}",innerCommand,type);
        }

    }
}
