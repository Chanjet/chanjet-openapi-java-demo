# Chanjet-Openapi-Java-Demo

畅捷通开放平台Java示例项目，需要先了解开放平台[Chanjet-Openapi-Java-Sdk](https://github.com/Chanjet/chanjet-openapi-java-sdk)

## 项目概述

该项目主要提供应用入驻和集成模块两种模式的基本对接流程demo。
com.chanjet.openpai.java.demo.controller.app目录下为应用入驻的demo。
com.chanjet.openpai.java.demo.controller.integration为集成模块的demo。
com.chanjet.openpai.java.demo.controller.auth目录下为应用开通和身份验证的demo。

## 快速使用

1. 修改该项目下resources目录下application.yml配置文件
```yaml
chanjet:
  openapi:
    gatewayUrl: https://openapi.chanjet.com #开放平台网关地址
    connectTimeout: 3000 #连接超时时间，单位ms
    readTimeout: 15000 #读取超时时间，单位ms
    appKey:  #需要填写在开放平台申请的appKey
    appSecret:  #需要填写在开放平台申请的appSecret
    secret:  #秘钥，用于解密，需要去开放平台自主填写，然后配置在此处
    redirectUri:  #Oauth重定向地址，需要去开放平台自主填写，然后配置在此处

spring:
  datasource:
    url: jdbc:postgresql://ip:port/dbname  #数据库的jdbc url
    username:   #数据库的用户名
    password:  #数据库的密码
    driverClassName: org.postgresql.Driver  #数据库的驱动，项目默认使用postgreSql
  jpa:
    hibernate:
      ddl-auto: update

  freemarker:
    template-loader-path: classpath:/templates
    suffix: .ftl
```
2. 运行ChanjetOpenapiJavaDemoApplication的main方法启动。
3. 项目使用jpa，可以自动建表，表实体配置查看com/chanjet/openapi/java/demo/entity目录。
4. 该项目使用了swagger2，可以在项目启动后可通过swagger地址查看接口信息，swagger地址：http://localhost:8080/swagger-ui.html#/
5. 应用开通需要将MessageController暴露的接口地址配置到开放平台的消息接收地址的配置中。
6. 身份验证需要将UserAuthController暴露的接口地址配置到开放平台的Oauth回调地址的配置中。
7. 应用开通时会自动下发临时授权码到消息接收地址。
8. 身份验证时用户授权完成后，会自动携带code跳转到Oauth回调地址。
9. 可信域名验证处理：替换src/main/resources/static下的CHANJET_CHECK.txt文件为从开放平台下载的校验文件。将当前域名添加到开放平台的可信域名管理中。