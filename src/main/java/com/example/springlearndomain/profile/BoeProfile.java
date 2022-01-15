package com.example.springlearndomain.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 23:49
 * @Version: 1.0
 * @Description:
 */

@Profile("boe-sg")
@Component
public class BoeProfile {
}
