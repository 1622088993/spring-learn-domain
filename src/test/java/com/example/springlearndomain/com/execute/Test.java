package com.example.springlearndomain.com.execute;

import com.example.springlearndomain.exectu.ExecuteInitConfig;
import com.example.springlearndomain.exectu.ExecuteEnum;
import com.example.springlearndomain.spring.CmdFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 11:26
 * @Version: 1.0
 * @Description:
 */


@SpringBootTest
public class Test {
    @Resource
    private ExecuteInitConfig executeConfig;

    @Resource
    CmdFactory cmdFactory;

    @org.junit.jupiter.api.Test
    public void test(){
        executeConfig.execute(ExecuteEnum.ONE.toString());
        executeConfig.execute(ExecuteEnum.TWO.toString());
        executeConfig.execute(ExecuteEnum.THREE.toString());
    }
}
