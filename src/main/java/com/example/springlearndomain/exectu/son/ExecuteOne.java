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
@Slf4j
@Component
@ExecuteTime(RunEnum.CLOSE)
public class ExecuteOne extends AspExecute {
    @Override
    public void execute() {
        log.info("one execute");
    }

    @Override
    public String getName() {
        return ExecuteEnum.ONE.toString();
    }
}
