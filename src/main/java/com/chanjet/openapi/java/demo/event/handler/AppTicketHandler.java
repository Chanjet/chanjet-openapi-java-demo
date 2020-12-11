package com.chanjet.openapi.java.demo.event.handler;


import com.chanjet.openapi.java.demo.dao.AppTicketDao;
import com.chanjet.openapi.java.demo.entity.AppTicket;
import com.chanjet.openapi.java.demo.event.ChanjetMsg;
import com.chanjet.openapi.java.demo.event.EventHandler;
import com.chanjet.openapi.java.demo.event.content.AppTicketContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * appTicket事件处理器
 *
 * @author: zsc
 * @create: 2020/11/5 6:02 下午
 **/
@Component("APP_TICKET")
public class AppTicketHandler implements EventHandler<AppTicketContent> {

    @Autowired
    private AppTicketDao appTicketDao;

    @Override
    public Object execute(ChanjetMsg<AppTicketContent> chanjetMsg) {
        AppTicket appTicket = appTicketDao.findAppTicketByAppKey(chanjetMsg.getAppKey());
        if (null == appTicket) {
            appTicket = new AppTicket();
            appTicket.setAppKey(chanjetMsg.getAppKey());
        }
        appTicket.setTicket(chanjetMsg.getBizContent().getAppTicket());
        appTicketDao.save(appTicket);
        return "success";
    }
}
