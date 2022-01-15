package com.example.springlearndomain.common.aspect;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 22:35
 * @Version: 1.0
 * @Description:
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
