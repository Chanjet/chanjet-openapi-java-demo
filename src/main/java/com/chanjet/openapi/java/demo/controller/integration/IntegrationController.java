package com.chanjet.openapi.java.demo.controller.integration;

import com.chanjet.openapi.java.demo.config.OpenApiConfig;
import com.chanjet.openapi.java.demo.request.AccountBookListRequest;
import com.chanjet.openapi.java.demo.response.AccountBookListResponse;
import com.chanjet.openapi.sdk.java.ChanjetClient;
import com.chanjet.openapi.sdk.java.domain.*;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.request.*;
import com.chanjet.openapi.sdk.java.response.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 集成模块示例demo
 * 1、授权，授权流程参考 https://dev.chanjet.com/docs/quickstart/ksrm/dqyhsq
 * 2、授权后调用接口
 * 3、单点登录，单点登录参考
 *
 * @author zsc
 * @create 2020/9/8 1:11 下午
 **/
@RestController
@RequestMapping("integration")
public class IntegrationController {
    @Autowired
    private OpenApiConfig openApiConfig;

    @Autowired
    private ChanjetClient chanjetClient;

    /**
     * 创建租户
     *
     * @param createTenantContent 创建租户业务请求参数
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "创建租户", httpMethod = "POST")
    @PostMapping("createTenant")
    public CreateTenantResponse createTenant(@RequestBody CreateTenantContent createTenantContent) throws ChanjetApiException {
        CreateTenantRequest createTenantRequest = new CreateTenantRequest();
        createTenantRequest.setAppKey(openApiConfig.getAppKey());
        createTenantRequest.setAppSecret(openApiConfig.getAppSecret());
        createTenantRequest.setRequestUri("/financial/orgAndUser/createTenant");
        createTenantRequest.setBizContent(createTenantContent);
        return chanjetClient.execute(createTenantRequest);
    }

    /**
     * 创建完租户后，该租户可以进行对指定的应用进行试用
     *
     * @param trailProductContent 产品试用的业务请求参数
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "产品试用", httpMethod = "POST")
    @PostMapping("trailProduct")
    public TrailProductResponse trailProduct(@RequestBody TrailProductContent trailProductContent) throws ChanjetApiException {
        TrailProductRequest trailProductRequest = new TrailProductRequest();
        trailProductRequest.setAppKey(openApiConfig.getAppKey());
        trailProductRequest.setAppSecret(openApiConfig.getAppSecret());
        trailProductRequest.setRequestUri("/financial/order/trailProduct");
        trailProductRequest.setBizContent(trailProductContent);
        return chanjetClient.execute(trailProductRequest);
    }

    /**
     * 创建完租户后，该租户可以进行代客下单，开通畅捷通的应用，应用未发布之前只能使用productId为4371的产品进行测试
     *
     * @param createOrderContent 创建租户的业务请求参数
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "代客下单", httpMethod = "POST")
    @PostMapping("createOrder")
    public CreateOrderResponse trailProduct(@RequestBody CreateOrderContent createOrderContent) throws ChanjetApiException {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setAppKey(openApiConfig.getAppKey());
        createOrderRequest.setAppSecret(openApiConfig.getAppSecret());
        createOrderRequest.setRequestUri("/financial/order/createOrder");
        createOrderRequest.setBizContent(createOrderContent);
        return chanjetClient.execute(createOrderRequest);
    }

    /**
     * 应用试用或代客下单后可以获取该租户的token，获取到该token可以使用该token调用开通的产品
     *
     * @param getTenantTokenContent 获取租户token的业务请求参数
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "获取租户token", httpMethod = "POST")
    @PostMapping("getTenantToken")
    public GetTenantTokenResponse getTenantToken(@RequestBody GetTenantTokenContent getTenantTokenContent) throws ChanjetApiException {
        GetTenantTokenRequest getTenantTokenRequest = new GetTenantTokenRequest();
        getTenantTokenRequest.setAppKey(openApiConfig.getAppKey());
        getTenantTokenRequest.setAppSecret(openApiConfig.getAppSecret());
        getTenantTokenRequest.setRequestUri("/financial/auth/getTenantToken");
        getTenantTokenRequest.setBizContent(getTenantTokenContent);
        return chanjetClient.execute(getTenantTokenRequest);
    }

    /**
     * 添加用户到租户，获取用户的token前需先将用户添加到租户
     *
     * @param addUserContent 添加用户业务请求参数
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    @PostMapping("addUser")
    public AddUserResponse addUser(@RequestBody AddUserContent addUserContent) throws ChanjetApiException {
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setAppKey(openApiConfig.getAppKey());
        addUserRequest.setAppSecret(openApiConfig.getAppSecret());
        addUserRequest.setRequestUri("/financial/orgAndUser/addUser");
        addUserRequest.setBizContent(addUserContent);
        return chanjetClient.execute(addUserRequest);
    }

    /**
     * 获取用户token，添加完用户可以获取该用户的token
     *
     * @param getUserTokenContent 获取用户token业务请求参数
     * @return
     * @throws ChanjetApiException
     */
    @ApiOperation(value = "获取用户token", httpMethod = "POST")
    @PostMapping("getUserToken")
    public GetUserTokenResponse getUserToken(@RequestBody GetUserTokenContent getUserTokenContent) throws ChanjetApiException {
        GetUserTokenRequest getUserTokenRequest = new GetUserTokenRequest();
        getUserTokenRequest.setAppKey(openApiConfig.getAppKey());
        getUserTokenRequest.setAppSecret(openApiConfig.getAppSecret());
        getUserTokenRequest.setRequestUri("/financial/orgAndUser/addUser");
        getUserTokenRequest.setBizContent(getUserTokenContent);
        return chanjetClient.execute(getUserTokenRequest);
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
    public AccountBookListResponse accountBookList(@RequestHeader("openToken") String openToken) throws ChanjetApiException {
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
}
