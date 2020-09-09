# chanjet-open-sdk

畅捷通开放平台Java示例项目，需要先了解开放平台[Chanjet-Openapi-Java-Sdk](https://github.com/Chanjet/chanjet-openapi-java-sdk)

## 项目概述

该项目主要提供应用入驻和集成模块两种模式的基本对接流程demo，com.chanjet.openpai.java.demo.controller.app
目录下为应用入驻的demo，com.chanjet.openpai.java.demo.controller.integration为集成模块的demo。

## 快速使用

1. 修改该项目下resources目录下的配置文件
```yaml
chanjet:
  openapi:
    gatewayUrl: #开放平台网关地址
    connectTimeout: #连接超时时间，单位ms
    readTimeout: #读取超时时间，单位ms
    appKey: #需要填写在开放平台申请的appKey
    appSecret: #需要填写在开放平台申请的appSecret
```
2. 运行ChanjetOpenapiJavaDemoApplication的main方法启动
3. 该项目使用了swagger2，可以在项目启动后可通过swagger地址查看接口信息，swagger地址：http://localhost:8080/swagger-ui.html#/
