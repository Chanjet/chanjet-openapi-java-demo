package com.chanjet.openapi.java.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 畅捷通开放平台的配置
 *
 * @author zsc
 * @create 2020/9/8 2:51 下午
 **/
@Configuration
@ConfigurationProperties("chanjet.openapi")
public class OpenApiConfig {
    /**
     * 开放平台网关地址
     */
    private String gatewayUrl;
    /**
     * 开放平台申请的appKey
     */
    private String appKey;
    /**
     * 开放平台申请的appSecret
     */
    private String appSecret;
    /**
     * 连接超时时间，单位ms
     */
    private int connectTimeout;
    /**
     * 读取超时时间，单位ms
     */
    private int readTimeout;

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    @Override
    public String toString() {
        return "OpenApiConfig{" +
                "gatewayUrl='" + gatewayUrl + '\'' +
                ", appKey='" + appKey + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", connectTimeout='" + connectTimeout + '\'' +
                ", readTimeout='" + readTimeout + '\'' +
                '}';
    }
}
