package com.chanjet.openapi.java.demo.dao;

import com.chanjet.openapi.java.demo.entity.AppTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zsc
 * @create: 2020/11/6 2:15 下午
 **/
@Repository
public interface AppTicketDao extends JpaRepository<AppTicket, Long> {
    AppTicket findAppTicketByAppKey(String appKey);
}
