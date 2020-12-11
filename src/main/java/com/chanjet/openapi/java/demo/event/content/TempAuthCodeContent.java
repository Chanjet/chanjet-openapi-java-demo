package com.chanjet.openapi.java.demo.event.content;

import lombok.Data;

/**
 * 企业临时授权码消息体
 *
 * @author: zsc
 * @create: 2020/11/5 6:08 下午
 **/
@Data
public class TempAuthCodeContent {
    /**
     * 企业临时授权码
     */
    private String tempAuthCode;
    /**
     * 状态值
     */
    private String state;
}
