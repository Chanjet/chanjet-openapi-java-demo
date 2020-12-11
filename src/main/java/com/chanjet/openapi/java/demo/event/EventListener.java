package com.chanjet.openapi.java.demo.event;

import com.chanjet.openapi.java.demo.utils.SpringUtil;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 *
 * @author: zsc
 * @create: 2020/11/5 5:10 下午
 **/
@Component
public class EventListener implements ApplicationListener<MsgEvent> {

    @Async
    @Override
    public void onApplicationEvent(MsgEvent event) {
        EventHandler eventHandler = SpringUtil.getBean(event.getChanjetMsg().getMsgType(), EventHandler.class);
        assert eventHandler != null;
        eventHandler.execute(event.getChanjetMsg());
    }
}
