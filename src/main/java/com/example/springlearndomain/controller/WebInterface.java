package com.example.springlearndomain.controller;


import com.example.springlearndomain.controller.request.TriggerRequest;

import com.example.springlearndomain.evrnt.MailEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("web")
@RestController
public class WebInterface {
    @Autowired
    private ApplicationContext applicationContext;  //容器事件由容器触发
    @RequestMapping("/test1")
    public void testDomainEvent(@RequestBody TriggerRequest request){
        System.out.println(request);
        applicationContext.publishEvent(new MailEvent(applicationContext,"nnnnnnnn"));
    }

}
