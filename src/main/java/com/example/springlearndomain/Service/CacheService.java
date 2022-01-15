package com.example.springlearndomain.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: YangLiJun
 * @Date: 2021/8/21 22:03
 * @Version: 1.0
 * @Description:
 */
@Service
@Slf4j
public class CacheService {

    @Cacheable(value = "name")
    public String getName(List name,Long num){

        log.info("input map is {}",name);
        System.out.println(" is run  ");

        return "get key";
    }

    public String getNameWithoutCache(String name){


        System.out.println(" is run  ");

        return "get key";
    }
}
