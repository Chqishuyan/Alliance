package com.lefu.model.entity;

import java.io.Serializable;

public class OperatorRecommender implements Serializable {



    private String id;

    private String recommenderNo;

    private String operatorUsername;

    private String operatorFlag;

    private String status;

    private Integer optimistic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecommenderNo() {
        return recommenderNo;
    }

    public void setRecommenderNo(String recommenderNo) {
        this.recommenderNo = recommenderNo;
    }

    public String getOperatorUsername() {
        return operatorUsername;
    }

    public void setOperatorUsername(String operatorUsername) {
        this.operatorUsername = operatorUsername;
    }

    public String getOperatorFlag() {
        return operatorFlag;
    }

    public void setOperatorFlag(String operatorFlag) {
        this.operatorFlag = operatorFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getOptimistic() {
        return optimistic;
    }

    public void setOptimistic(Integer optimistic) {
        this.optimistic = optimistic;
    }
}