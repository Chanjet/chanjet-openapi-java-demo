package com.chanjet.openapi.java.demo.event.handler;


import com.chanjet.openapi.java.demo.dao.AppTicketDao;
import com.chanjet.openapi.java.demo.dao.OrganizationDao;
import com.chanjet.openapi.java.demo.entity.AppTicket;
import com.chanjet.openapi.java.demo.entity.Organization;
import com.chanjet.openapi.java.demo.event.ChanjetMsg;
import com.chanjet.openapi.java.demo.event.EventHandler;
import com.chanjet.openapi.java.demo.event.content.TempAuthCodeContent;
import com.chanjet.openapi.java.demo.spi.ChanjetSpi;
import com.chanjet.openapi.sdk.java.domain.GetAppAccessTokenContent;
import com.chanjet.openapi.sdk.java.domain.GetPermanentAuthCodeContent;
import com.chanjet.openapi.sdk.java.response.GetAppAccessTokenResponse;
import com.chanjet.openapi.sdk.java.response.GetPermanentAuthCodeResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 企业临时授权码事件处理器
 *
 * @author: zsc
 * @create: 2020/11/5 6:02 下午
 **/
@Log4j2
@Service("TEMP_AUTH_CODE")
public class TempAuthCodeHandler implements EventHandler<TempAuthCodeContent> {

    @Autowired
    private AppTicketDao appTicketDao;
    @Autowired
    private ChanjetSpi chanjetSpi;
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    public Object execute(ChanjetMsg<TempAuthCodeContent> chanjetMsg) {
        try {
            TempAuthCodeContent tempAuthCodeContent = chanjetMsg.getBizContent();
            String tempAuthCode = tempAuthCodeContent.getTempAuthCode();
            AppTicket appTicket = appTicketDao.findAppTicketByAppKey(chanjetMsg.getAppKey());
            GetAppAccessTokenContent getAppAccessTokenContent = new GetAppAccessTokenContent();
            getAppAccessTokenContent.setAppTicket(appTicket.getTicket());
            GetAppAccessTokenResponse getAppAccessTokenResponse = chanjetSpi.getAppAccessToken(getAppAccessTokenContent);
            GetPermanentAuthCodeContent getPermanentAuthCodeContent = new GetPermanentAuthCodeContent();
            getPermanentAuthCodeContent.setTempAuthCode(tempAuthCode);
            getPermanentAuthCodeContent.setAppAccessToken(getAppAccessTokenResponse.getResult().getAppAccessToken());
            GetPermanentAuthCodeResponse getPermanentAuthCodeResponse = chanjetSpi.getPermanentAuthCode(getPermanentAuthCodeContent);
            String orgId = getPermanentAuthCodeResponse.getResult().getOrgId();
            Organization organization = organizationDao.findOrganizationByOrgId(orgId);
            if (null == organization) {
                organization = new Organization();
                organization.setOrgId(orgId);
            }
            organization.setPermanentAuthCode(getPermanentAuthCodeResponse.getResult().getPermanentAuthCode());
            organizationDao.save(organization);
            return "success";
        } catch (Exception e) {
            log.error("处理临时授权码消息异常", e);
            return "fail";
        }
    }
}
