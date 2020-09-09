package com.chanjet.openapi.java.demo.response;

import com.chanjet.openapi.sdk.java.AbstractChanjetResponse;

import java.util.Date;

/**
 * 获取用户请求的响应
 *
 * @author: zsc
 * @create: 2020/9/9 2:35 下午
 **/
public class UserResponse extends AbstractChanjetResponse {
    private String orgType;
    private String orgFullName;
    private String remark;
    private String userType;
    private String loginAccount;
    private String orgId;
    private String username;
    private String userId;
    private Date modifyTime;
    private String signature;
    private String companyName;
    private String defaultOrganization;
    private boolean result;
    private Date createTime;
    private String headPicture;
    private String origin;
    private String orgName;
    private String userVersion;
    private String userLongId;

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setDefaultOrganization(String defaultOrganization) {
        this.defaultOrganization = defaultOrganization;
    }

    public String getDefaultOrganization() {
        return defaultOrganization;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setUserVersion(String userVersion) {
        this.userVersion = userVersion;
    }

    public String getUserVersion() {
        return userVersion;
    }

    public void setUserLongId(String userLongId) {
        this.userLongId = userLongId;
    }

    public String getUserLongId() {
        return userLongId;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "orgType='" + orgType + '\'' +
                ", orgFullName='" + orgFullName + '\'' +
                ", remark='" + remark + '\'' +
                ", userType='" + userType + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", orgId='" + orgId + '\'' +
                ", username='" + username + '\'' +
                ", userId='" + userId + '\'' +
                ", modifyTime=" + modifyTime +
                ", signature='" + signature + '\'' +
                ", companyName='" + companyName + '\'' +
                ", defaultOrganization='" + defaultOrganization + '\'' +
                ", result=" + result +
                ", createTime=" + createTime +
                ", headPicture='" + headPicture + '\'' +
                ", origin='" + origin + '\'' +
                ", orgName='" + orgName + '\'' +
                ", userVersion='" + userVersion + '\'' +
                ", userLongId='" + userLongId + '\'' +
                '}';
    }
}
