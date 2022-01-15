package com.example.springlearndomain.aop.anno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/30 22:49
 * @Version: 1.0
 * @Description:
 */
@AllArgsConstructor
public enum RunEnum {
    CREATE(1,"create"),
    CLOSE(2,"CLOSE");

    @Getter
    private Integer code;

    @Getter
    private String desc;
}
