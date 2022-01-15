package com.example.springlearndomain.evrnt;

import lombok.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;



public class MailEvent  extends ApplicationContextEvent {
    @Getter
    String name;

    public MailEvent(ApplicationContext source,String name) {
        super(source);
        this.name=name;
    }
}
