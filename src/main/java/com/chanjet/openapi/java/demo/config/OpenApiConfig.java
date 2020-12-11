package com.chanjet.openapi.java.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 畅捷通开放平台的配置
 *
 * @author zsc
 * @create 2020/9/8 2:51 下午
 **/
@Data
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
    /**
     * 加签key，用于加签和解密
     */
    private String secret;
    /**
     * Oauth重定向地址
     */
    private String redirectUri;
}
