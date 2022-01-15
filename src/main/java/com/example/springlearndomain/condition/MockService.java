package com.example.springlearndomain.condition;

import com.example.springlearndomain.condition.config.BoeConfig;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 21:45
 * @Version: 1.0
 * @Description:
 */


@Component
@Conditional(BoeConfig.class)
public class MockService {
}
