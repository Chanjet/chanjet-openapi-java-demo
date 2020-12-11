package com.chanjet.openapi.java.demo.dao;

import com.chanjet.openapi.java.demo.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: zsc
 * @create: 2020/11/6 2:17 下午
 **/
@Repository
public interface OrganizationDao extends JpaRepository<Organization, Long> {
    Organization findOrganizationByOrgId(String orgId);
}
