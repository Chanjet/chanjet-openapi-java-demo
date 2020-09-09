package com.chanjet.openapi.java.demo.request;

import com.chanjet.openapi.java.demo.response.AccountBookListResponse;
import com.chanjet.openapi.sdk.java.AbstractChanjetRequest;
import com.chanjet.openapi.sdk.java.enums.HttpMethod;

/**
 * 获取账套列表请求
 *
 * @author zsc
 * @create 2020/9/8 3:05 下午
 **/
public class AccountBookListRequest extends AbstractChanjetRequest<AccountBookListResponse> {

    @Override
    public Class<AccountBookListResponse> getResponseClass() {
        return AccountBookListResponse.class;
    }

    @Override
    public HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }
}
