package com.example.springlearndomain.aop;

import com.alibaba.fastjson.JSON;
import com.example.springlearndomain.aop.query.CommonQuery;
import com.example.springlearndomain.dto.PersonDTO;
import jdk.security.jarsigner.JarSigner;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/12 13:40
 * @Version: 1.0
 * @Description:
 */

@SpringBootTest
@Slf4j
public class AopSpringTest {
    @Resource
    private CommonQuery commonQuery;
    @Test
    public void test(){
        PersonDTO hbb = commonQuery.queryPersonByIdAnsSave(12, "hbb");
        log.info("result {}",JSON.toJSONString(hbb));
    }

}
