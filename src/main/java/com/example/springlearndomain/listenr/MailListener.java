package com.example.springlearndomain.listenr;

import com.alibaba.fastjson.JSON;
import com.example.springlearndomain.evrnt.MailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


@Component
@Slf4j
public class MailListener implements ApplicationListener<MailEvent> {
    @Override
    public void onApplicationEvent(MailEvent mailEvent) {
        log.info("MailListener  listen msg is {}",mailEvent);
    }
}
