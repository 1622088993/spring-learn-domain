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
@ExecuteTime(RunEnum.CLOSE)
public class CommandTwo implements InnerCommand {
    @Override
    public String getType() {
        return "2";
    }

    @Override
    public String handleSubmit() {
        return "method 2 execute";
    }
}
