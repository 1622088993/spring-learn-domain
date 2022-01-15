package com.example.springlearndomain;

import com.example.springlearndomain.condition.LookService;
import com.example.springlearndomain.profile.BoeProfile;
import com.example.springlearndomain.profile.ProdProfile;
import com.example.springlearndomain.utiles.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.annotation.Retention;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 23:29
 * @Version: 1.0
 * @Description:
 */
@SpringBootTest
@Slf4j
public class ConditionalTest {





    @Test
    public void test(){
        ProdProfile beanByClass = SpringUtil.getBeanByClass(ProdProfile.class);
        BoeProfile beanByClass1 = SpringUtil.getBeanByClass(BoeProfile.class);
        log.info("");

    }
}
