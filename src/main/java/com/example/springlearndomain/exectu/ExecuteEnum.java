package com.example.springlearndomain.exectu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/24 11:16
 * @Version: 1.0
 * @Description:
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum ExecuteEnum {
    ONE(1,"one"),
    TWO(2,"two"),
    THREE(3,"three");

    private Integer code;

    private String value;
}
