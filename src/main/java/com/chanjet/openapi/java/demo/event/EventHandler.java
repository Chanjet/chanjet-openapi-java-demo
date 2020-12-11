package com.chanjet.openapi.java.demo.event;

/**
 * 事件处理
 *
 * @author: zsc
 * @create: 2020/11/5 6:04 下午
 **/
public interface EventHandler<T> {
    /**
     * 事件的处理方法
     *
     * @param chanjetMsg
     * @return
     */
    Object execute(ChanjetMsg<T> chanjetMsg);
}
