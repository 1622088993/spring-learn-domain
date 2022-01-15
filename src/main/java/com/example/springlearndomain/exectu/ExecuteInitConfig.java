package com.example.springlearndomain.exectu;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 11:21
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
public class ExecuteInitConfig {

    @Resource
    private List<AspExecute> aspExecutes;



    public void execute(String name){
        AspExecute aspExecute = aspExecutes.stream().filter(asp -> Objects.equals(name, asp.getName())).findFirst().orElse(null);
        ExecuteTime annotation = AnnotationUtils.findAnnotation(aspExecute.getClass(), ExecuteTime.class);
        if (Objects.nonNull(annotation)){
            log.info("annotation {}",annotation.value());
        }
        if (Objects.nonNull(aspExecute)){
            aspExecute.execute();
        }
    }
}
