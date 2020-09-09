package com.chanjet.openapi.java.demo.response;

import com.chanjet.openapi.java.demo.response.content.AccountBook;
import com.chanjet.openapi.sdk.java.ChanjetResponse;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 获取账套列表响应
 *
 * @author zsc
 * @create 2020/9/8 3:05 下午
 **/
public class AccountBookListResponse<T extends AccountBook> extends ArrayList<T> implements ChanjetResponse, Serializable {
    private static final long serialVersionUID = 1L;
}
