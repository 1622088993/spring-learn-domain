package com.example.springlearndomain;

import com.example.springlearndomain.Service.service.UserService;
import com.example.springlearndomain.aop.CheckService;
import com.example.springlearndomain.type.CheckServiceMethod;
import com.google.common.base.CharMatcher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/22 23:45
 * @Version: 1.0
 * @Description:
 */
@SpringBootTest
@Slf4j
public class AopTest {

    @Resource
    UserService userService;

    @Resource
    private CheckService checkService;

    @Resource
    private CheckServiceMethod checkServiceMethod;



    @Test
    public void test(){
        userService.getNum();
    }

    @Test
    public void testCheck(){
        checkService.checkNum("ylj",1);
    }


    @Test
    public void testAop(){
        checkService.save();
        log.info("method ----2");
        checkServiceMethod.saveUser();

        String query = CharMatcher.anyOf("Query").retainFrom("1Qery");
        System.out.println(query);

    }



}
