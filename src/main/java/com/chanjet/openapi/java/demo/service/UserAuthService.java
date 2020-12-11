package com.chanjet.openapi.java.demo.service;

import com.chanjet.openapi.java.demo.entity.UserInfo;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: zsc
 * @create: 2020/12/9 下午3:32
 **/
public interface UserAuthService {
    /**
     * 接收用户授权码
     *
     * @param code
     * @param response
     */
    UserInfo receiveCode(String code, HttpServletResponse response) throws ChanjetApiException;
}
