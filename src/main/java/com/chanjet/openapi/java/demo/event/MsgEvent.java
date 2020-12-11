package com.chanjet.openapi.java.demo.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author: zsc
 * @create: 2020/11/6 10:45 上午
 **/
public class MsgEvent extends ApplicationContextEvent {

    private ChanjetMsg chanjetMsg;

    public MsgEvent(ApplicationContext source, ChanjetMsg chanjetMsg) {
        super(source);
        this.chanjetMsg = chanjetMsg;
    }

    public ChanjetMsg getChanjetMsg() {
        return chanjetMsg;
    }

    public void setChanjetMsg(ChanjetMsg chanjetMsg) {
        this.chanjetMsg = chanjetMsg;
    }
}
