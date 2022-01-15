package com.example.springlearndomain.strategy.execute;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/12 23:49
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
public class CommandExecute {

    @Resource
    CommandFactory commandFactory;

    public void execute(String msg){
        InnerCommand innerCommand = commandFactory.map.get(msg);
        ExecuteTime annotation = AnnotationUtils.findAnnotation(InnerCommand.class, ExecuteTime.class);
        log.info("annotation  is {}",annotation);
        String s = innerCommand.handleSubmit();
        System.out.println(s);
    }
}
