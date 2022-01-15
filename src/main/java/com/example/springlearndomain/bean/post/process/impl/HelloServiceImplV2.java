package com.example.springlearndomain.bean.post.process.impl;

import com.example.springlearndomain.bean.post.process.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Author: YangLiJun
 * @Date: 2021/12/6 0:24
 * @Version: 1.0
 * @Description:
 */

@Service
public class HelloServiceImplV2 implements HelloService {
    public void sayHello(){
        System.out.println("Hello from V2");
    }
    public void sayHi(){
        System.out.println("Hi from V2");
    }
}