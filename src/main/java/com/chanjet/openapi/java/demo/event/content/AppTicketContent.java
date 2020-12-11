package com.chanjet.openapi.java.demo.event.content;

import lombok.Data;

/**
 * appTicket消息体
 *
 * @author: zsc
 * @create: 2020/11/5 6:07 下午
 **/
@Data
public class AppTicketContent {
    /**
     * 开放平台推送的appTicket
     */
    private String appTicket;
}
