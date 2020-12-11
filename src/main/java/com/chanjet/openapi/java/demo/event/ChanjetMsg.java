package com.chanjet.openapi.java.demo.event;

import lombok.Data;

/**
 * 畅捷通的消息,也兼容了长沙银行的消息
 *
 * @author: zsc
 * @create: 2020/11/5 5:47 下午
 **/
@Data
public class ChanjetMsg<T> {
    /**
     * 开放平台的appKey
     */
    private String appKey;
    /**
     * 消息类型
     */
    private String msgType;
    /**
     * bizContent的实体
     */
    private T bizContent;
}
