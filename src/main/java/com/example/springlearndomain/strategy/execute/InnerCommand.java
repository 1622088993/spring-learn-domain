package com.example.springlearndomain.strategy.execute;

import java.io.Serializable;

/**
 * @Author: YangLiJun
 * @Date: 2021/10/12 23:36
 * @Version: 1.0
 * @Description:
 */

public interface InnerCommand{


    String getType();



    String handleSubmit();
}
