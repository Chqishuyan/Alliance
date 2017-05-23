package com.lefu.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Recommender implements Serializable{

    private static final long serialVersionUID =63452525546L;

    private String id;

    private Integer optimistic;

    private String recommenderNo;

    private String recommenderName;

    private String organizationCode;

    private String receiveAddress;

    private String status;

    private Date createTime;

    private Date authTime;

    private String auditUser;

    private Byte recommenderFlag;

    private String phoneNo;

    private String agentNo;

    private String identityNo;

    private String qrcodePath;


    public void setId(String id) {
        this.id = id;
    }

    public void setOptimistic(Integer optimistic) {
        this.optimistic = optimistic;
    }

    public void setRecommenderNo(String recommenderNo) {
        this.recommenderNo = recommenderNo;
    }

    public void setRecommenderName(String recommenderName) {
        this.recommenderName = recommenderName;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setAuthTime(Date authTime) {
        this.authTime = authTime;
    }

    public void setAuditUser(String auditUser) {
        this.auditUser = auditUser;
    }

    public void setRecommenderFlag(Byte recommenderFlag) {
        this.recommenderFlag = recommenderFlag;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public void setQrcodePath(String qrcodePath) {
        this.qrcodePath = qrcodePath;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public Integer getOptimistic() {
        return optimistic;
    }

    public String getRecommenderNo() {
        return recommenderNo;
    }

    public String getRecommenderName() {
        return recommenderName;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getAuthTime() {
        return authTime;
    }

    public String getAuditUser() {
        return auditUser;
    }

    public Byte getRecommenderFlag() {
        return recommenderFlag;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public String getQrcodePath() {
        return qrcodePath;
    }

    @Override
    public String toString() {
        return "Recommender{" +
                "id='" + id + '\'' +
                ", optimistic=" + optimistic +
                ", recommenderNo='" + recommenderNo + '\'' +
                ", recommenderName='" + recommenderName + '\'' +
                ", organizationCode='" + organizationCode + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", authTime=" + authTime +
                ", auditUser='" + auditUser + '\'' +
                ", recommenderFlag=" + recommenderFlag +
                ", phoneNo='" + phoneNo + '\'' +
                ", agentNo='" + agentNo + '\'' +
                ", identityNo='" + identityNo + '\'' +
                ", qrcodePath='" + qrcodePath + '\'' +
                '}';
    }
}