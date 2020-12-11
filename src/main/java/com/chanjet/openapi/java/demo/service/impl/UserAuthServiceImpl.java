package com.chanjet.openapi.java.demo.service.impl;

import com.chanjet.openapi.java.demo.config.OpenApiConfig;
import com.chanjet.openapi.java.demo.dao.UserDao;
import com.chanjet.openapi.java.demo.entity.UserInfo;
import com.chanjet.openapi.java.demo.service.UserAuthService;
import com.chanjet.openapi.java.demo.spi.ChanjetSpi;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import com.chanjet.openapi.sdk.java.response.GetTokenResponse;
import com.chanjet.openapi.sdk.java.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户授权
 *
 * @author: zsc
 * @create: 2020/12/9 下午3:33
 **/
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private ChanjetSpi chanjetSpi;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OpenApiConfig openApiConfig;

    @Override
    public UserInfo receiveCode(String code, HttpServletResponse response) throws ChanjetApiException {
        GetTokenResponse getTokenResponse = chanjetSpi.getToken(code, openApiConfig.getRedirectUri());
        //保存用户信息
        UserInfo user = userDao.findUserByOrgIdAndUserId(getTokenResponse.getResult().getOrgId(), getTokenResponse.getResult().getUserId());
        if (null == user) {
            user = new UserInfo();
            user.setOrgId(getTokenResponse.getResult().getOrgId());
            user.setUserId(getTokenResponse.getResult().getUserId());
        }
        user.setToken(getTokenResponse.getResult().getAccessToken());
        user.setUserAuthPermanentCode(getTokenResponse.getResult().getUserAuthPermanentCode());
        //获取畅捷通用户信息
        UserResponse userResponse = chanjetSpi.user(user.getToken());
        user.setName(userResponse.getName());
        userDao.save(user);
        return user;
    }
}
