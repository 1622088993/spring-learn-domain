package com.example.springlearndomain.condition;

import com.google.common.base.CharMatcher;
import org.junit.jupiter.api.Test;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/12 15:06
 * @Version: 1.0
 * @Description:
 */

public class LocalTest {


    @Test
    public void testAop(){

        int query = CharMatcher.anyOf("Query").countIn("1Qeryu");
        System.out.println(query);


    }
}
