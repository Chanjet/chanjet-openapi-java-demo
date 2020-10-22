package com.chanjet.openapi.java.demo.config;

import com.chanjet.openapi.sdk.java.ChanjetClient;
import com.chanjet.openapi.sdk.java.DefaultChanjetClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化畅捷通SDK client
 *
 * @author zsc
 * @create 2020/9/8 11:16 上午
 **/
@Configuration
public class ChanjetClientConfig {
    @Bean
    public ChanjetClient chanjetClient(OpenApiConfig openApiConfig) {
        return new DefaultChanjetClient(openApiConfig.getGatewayUrl(), openApiConfig.getSignKey());
    }
}
