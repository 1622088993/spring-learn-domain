package com.example.springlearndomain.condition;

import com.example.springlearndomain.strategy.execute.CommandExecute;
import com.example.springlearndomain.utiles.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 21:52
 * @Version: 1.0
 * @Description:
 */
@SpringBootTest
public class SpringConditionTest {

    @Resource
    private SpringUtil springUtil;

    @Resource
    private CommandExecute commandExecute;
   @Test
    public void test(){
       commandExecute.execute("1");
   }
}
