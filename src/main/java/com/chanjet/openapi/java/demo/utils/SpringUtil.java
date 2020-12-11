package com.chanjet.openapi.java.demo.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 根据实现类的类名获取spring加载的对象
 * Created by zhangshuanchao on 2020/3/6.
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    public SpringUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) {
        if (applicationContext == null) {
            applicationContext = arg0;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}
