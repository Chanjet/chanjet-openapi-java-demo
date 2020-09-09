package com.chanjet.openapi.java.demo.response.content;

import java.io.Serializable;

/**
 * 账套列表响应
 *
 * @author zsc
 * @create 2020/9/8 3:16 下午
 **/
public class AccountBook implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 账套ID
     */
    private Long id;
    /**
     * 会计制度ID
     */
    private Long acctgSystemId;
    /**
     * 是否禁用
     */
    private Boolean disabled;
    /**
     * 是否隐藏
     */
    private Boolean isHidden;
    /**
     * 当前财务数据期间
     */
    private String latestFiOpenPeriod;
    /**
     * 账套名
     */
    private String name;
    /**
     * 开账期间
     */
    private String openingPeriod;
    /**
     * 税号
     */
    private String taxNo;
    /**
     * 纳税性质
     */
    private String taxpayerTypeEnum;
    /**
     * 账套编码
     */
    private String bookCode;
    /**
     * 凭证是否需要审核
     */
    private Boolean acctgTransApprovalRequired;
    /**
     * 报税行业id
     */
    private Long taxIndustryId;
    /**
     * 启用次数
     */
    private Integer enabledTimes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAcctgSystemId() {
        return acctgSystemId;
    }

    public void setAcctgSystemId(Long acctgSystemId) {
        this.acctgSystemId = acctgSystemId;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public String getLatestFiOpenPeriod() {
        return latestFiOpenPeriod;
    }

    public void setLatestFiOpenPeriod(String latestFiOpenPeriod) {
        this.latestFiOpenPeriod = latestFiOpenPeriod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOpeningPeriod() {
        return openingPeriod;
    }

    public void setOpeningPeriod(String openingPeriod) {
        this.openingPeriod = openingPeriod;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getTaxpayerTypeEnum() {
        return taxpayerTypeEnum;
    }

    public void setTaxpayerTypeEnum(String taxpayerTypeEnum) {
        this.taxpayerTypeEnum = taxpayerTypeEnum;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Boolean getAcctgTransApprovalRequired() {
        return acctgTransApprovalRequired;
    }

    public void setAcctgTransApprovalRequired(Boolean acctgTransApprovalRequired) {
        this.acctgTransApprovalRequired = acctgTransApprovalRequired;
    }

    public Long getTaxIndustryId() {
        return taxIndustryId;
    }

    public void setTaxIndustryId(Long taxIndustryId) {
        this.taxIndustryId = taxIndustryId;
    }

    public Integer getEnabledTimes() {
        return enabledTimes;
    }

    public void setEnabledTimes(Integer enabledTimes) {
        this.enabledTimes = enabledTimes;
    }

    @Override
    public String toString() {
        return "AccountBook{" +
                "id=" + id +
                ", acctgSystemId=" + acctgSystemId +
                ", disabled=" + disabled +
                ", isHidden=" + isHidden +
                ", latestFiOpenPeriod='" + latestFiOpenPeriod + '\'' +
                ", name='" + name + '\'' +
                ", openingPeriod='" + openingPeriod + '\'' +
                ", taxNo='" + taxNo + '\'' +
                ", taxpayerTypeEnum='" + taxpayerTypeEnum + '\'' +
                ", bookCode='" + bookCode + '\'' +
                ", acctgTransApprovalRequired=" + acctgTransApprovalRequired +
                ", taxIndustryId=" + taxIndustryId +
                ", enabledTimes=" + enabledTimes +
                '}';
    }
}
