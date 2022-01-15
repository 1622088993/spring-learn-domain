package com.example.springlearndomain.strategy.execute.impl;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import com.example.springlearndomain.aop.anno.RunEnum;
import com.example.springlearndomain.strategy.execute.InnerCommand;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/12 23:42
 * @Version: 1.0
 * @Description:
 */
@Component
@ExecuteTime(RunEnum.CREATE)
public class CommandThree implements InnerCommand {
    @Override
    public String getType() {
        return "3";
    }

    @Override
    public String handleSubmit() {
        return "method 3 execute";
    }
}
