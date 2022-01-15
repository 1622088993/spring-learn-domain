package com.example.springlearndomain;

import com.example.springlearndomain.Service.CacheService;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/21 22:20
 * @Version: 1.0
 * @Description:
 */
@SpringBootTest
public class CacheTest {
    @Resource
    CacheService cacheService;



    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    @Test
    public void test(){
        for (int i = 0; i < 10; i++) {
            Map<String, Data> objectObjectMap = Maps.newHashMap("",new Data());
            ArrayList<String> hahhaha =new ArrayList<String>();
            hahhaha.add("1231");

            System.out.println(hahhaha.hashCode());
            cacheService.getName(hahhaha,1888888888888888L);

        }
    }
    class Data{

    }
}
