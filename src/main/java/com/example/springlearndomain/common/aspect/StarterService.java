package com.example.springlearndomain.common.aspect;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/29 22:36
 * @Version: 1.0
 * @Description:
 */

public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }
}
