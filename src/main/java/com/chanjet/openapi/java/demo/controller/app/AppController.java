package com.chanjet.openapi.java.demo.controller.app;

import com.chanjet.openapi.java.demo.config.OpenApiConfig;
import com.chanjet.openapi.java.demo.request.AccountBookListRequest;
import com.chanjet.openapi.java.demo.request.UserRequest;
import com.chanjet.openapi.java.demo.response.AccountBookListResponse;
import com.chanjet.openapi.java.demo.response.UserResponse;
import com.chanjet.openapi.java.demo.response.content.AccountBook;
import com.chanjet.openapi.sdk.java.ChanjetClient;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.GetLoginUrlRequest;
import com.chanjet.openapi.sdk.java.request.GetTokenRequest;
import com.chanjet.openapi.sdk.java.response.GetLoginUrlResponse;
import com.chanjet.openapi.sdk.java.response.GetTokenResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 应用入驻示例demo
 * 1、授权，授权流程参考 https://dev.chanjet.com/docs/quickstart/ksrm/dqyhsq
 * 2、授权后调用接口，以好会计获取账套列表、获取用户信息两个接口为例
 * 3、单点登录，单点登录参考
 *
 * @author zsc
 * @create 2020/9/8 1:11 下午
 **/
@RestController
@RequestMapping("app")
public class AppController {
    @Autowired
    private OpenApiConfig openApiConfig;
    @Autowired
    private ChanjetClient chanjetClient;

    /**
     * OAuth回调地址接口
     *
     * @param code 开放平台的授权码
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "OAuth回调地址接口", httpMethod = "GET")
    @GetMapping("receiveCode")
    public GetTokenResponse receiveCode(@RequestParam("code") String code) throws ChanjetApiException {
        GetTokenRequest getTokenRequest = new GetTokenRequest();
        getTokenRequest.addQueryParam("appKey", openApiConfig.getAppKey());
        getTokenRequest.addQueryParam("grantType", "authorization_code");
        //填写开发者的真实OAuth回调地址
        getTokenRequest.addQueryParam("redirectUri", "http://127.0.0.1:8080/app/receiveCode");
        getTokenRequest.addQueryParam("code", code);
        getTokenRequest.setRequestUri("/auth/getToken");
        //开发者应用内部在这需要将token保存起来，然后将页面重定向开发者应用页面
        //demo项目是直接将token的响应返回
        return chanjetClient.execute(getTokenRequest);
    }

    /**
     * 获取好会计的账套列表
     *
     * @param openToken 获取的租户token或用户token
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "获取好会计的账套列表", httpMethod = "GET")
    @GetMapping("/accounting/accountBook/list")
    public AccountBookListResponse<AccountBook> accountBookList(@RequestHeader("openToken") String openToken) throws ChanjetApiException {
        AccountBookListRequest accountBookListRequest = new AccountBookListRequest();
        accountBookListRequest.setAppKey(openApiConfig.getAppKey());
        accountBookListRequest.setAppSecret(openApiConfig.getAppSecret());
        accountBookListRequest.setOpenToken(openToken);
        accountBookListRequest.setRequestUri("/accounting/accountBook/list");
        return chanjetClient.execute(accountBookListRequest);
    }

    /**
     * 使用用户token或租户token获取单点登录地址，获取到的单点登录地址可直接使用
     *
     * @param openToken 开放平台token
     * @param state     状态值，需要UrlEncode，详情包含参数参考接口文档
     * @throws ChanjetApiException
     * @throws IOException
     */
    @ApiOperation(value = "获取单点登录地址", httpMethod = "GET")
    @GetMapping("getLoginUrl")
    public GetLoginUrlResponse login(@RequestHeader("openToken") String openToken, @RequestParam("state") String state) throws ChanjetApiException {
        GetLoginUrlRequest getLoginUrlRequest = new GetLoginUrlRequest();
        getLoginUrlRequest.setAppKey(openApiConfig.getAppKey());
        getLoginUrlRequest.setAppSecret(openApiConfig.getAppSecret());
        getLoginUrlRequest.setOpenToken(openToken);
        getLoginUrlRequest.addQueryParam("state", state);
        getLoginUrlRequest.setRequestUri("/authSite/sso/getLoginUrl");
        return chanjetClient.execute(getLoginUrlRequest);
    }

    /**
     * 获取用户信息
     *
     * @param openToken
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "获取用户信息", httpMethod = "GET")
    @GetMapping("user")
    public UserResponse user(@RequestHeader("openToken") String openToken) throws ChanjetApiException {
        UserRequest userRequest = new UserRequest();
        userRequest.setAppKey(openApiConfig.getAppKey());
        userRequest.setAppSecret(openApiConfig.getAppSecret());
        userRequest.setOpenToken(openToken);
        userRequest.setRequestUri("/accounting/cia/api/v1/user");
        return chanjetClient.execute(userRequest);
    }

}
