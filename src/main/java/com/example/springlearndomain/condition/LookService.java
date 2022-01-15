package com.example.springlearndomain.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 23:25
 * @Version: 1.0
 * @Description:
 */
@Component
@Conditional(AbstractLookService.class)
public class LookService {
}
