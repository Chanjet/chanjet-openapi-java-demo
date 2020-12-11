package com.chanjet.openapi.java.demo.controller.auth;

import com.chanjet.openapi.java.demo.entity.UserInfo;
import com.chanjet.openapi.java.demo.service.UserAuthService;
import com.chanjet.openapi.sdk.java.exception.ChanjetApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * 接收授权信息并跳转前端页面
 *
 * @author: zsc
 * @create: 2020/12/9 下午3:31
 **/
@RequestMapping("auth")
@Controller
public class UserAuthController {
    @Autowired
    UserAuthService userAuthService;

    /**
     * 接收用户授权码
     *
     * @param code
     * @param response
     * @throws ChanjetApiException
     */
    @GetMapping("receiveCode")
    public ModelAndView receiveCode(String code, HttpServletResponse response) throws ChanjetApiException {
        //接收code后返回用户基本信息
        UserInfo userInfo = userAuthService.receiveCode(code, response);
        //设置用户名，并重定向到前端页面，前端页面获取到用户名并展示
        ModelAndView modelAndView = new ModelAndView("authSuccess");
        modelAndView.addObject("name", userInfo.getName());
        return modelAndView;
    }
}
