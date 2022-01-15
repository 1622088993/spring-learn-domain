package com.example.springlearndomain.strategy.execute.impl;

import com.example.springlearndomain.aop.anno.ExecuteTime;
import com.example.springlearndomain.aop.anno.RunEnum;
import com.example.springlearndomain.strategy.execute.InnerCommand;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/12 23:41
 * @Version: 1.0
 * @Description:
 */
@Component
@ExecuteTime(RunEnum.CREATE)
public class CommandOne implements InnerCommand {
    @Override
    public String getType() {
        return "1";
    }

    @Override
    public String handleSubmit() {
        return "method 1 execute";
    }
}
