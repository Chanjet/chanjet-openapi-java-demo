package com.chanjet.openapi.java.demo.request;

import com.chanjet.openapi.java.demo.response.UserResponse;
import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;

/**
 * 获取用户信息请求
 *
 * @author: zsc
 * @create: 2020/9/9 2:34 下午
 **/
public class UserRequest extends AbstractChanjetRequest<UserResponse> {

    @Override
    public Class<UserResponse> getResponseClass() {
        return UserResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
