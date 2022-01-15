package com.example.springlearndomain.exectu.son;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import com.example.springlearndomain.aop.anno.RunEnum;
import com.example.springlearndomain.exectu.AspExecute;
import com.example.springlearndomain.exectu.ExecuteEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 11:14
 * @Version: 1.0
 * @Description:
 */
@Component
@Slf4j
@ExecuteTime(RunEnum.CREATE)
public class ExecuteTwo extends AspExecute {
    @Override
    public void execute() {
        log.info("two execute");
    }

    @Override
    public String getName() {
        return ExecuteEnum.TWO.toString();
    }
}
