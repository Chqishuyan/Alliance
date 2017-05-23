package com.lefu.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.lefu.model.beans.ReturnBean;
import com.lefu.model.beans.ReturnCode;
import com.lefu.model.entity.Recommender;
import com.lefu.service.dao.RecommenderMapper;
import com.lefu.service.service.RecommenderService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by shuyan.qi on 2017/4/18.
 */
@Service
public class RecommenderServiceImpl implements RecommenderService {
    private Logger logger = LoggerFactory.getLogger(RecommenderServiceImpl.class);

    @Resource
    private RecommenderMapper recommenderMapper;

    /**
     * 查询我的信息
     * @param recommenderNo
     * @return
     */
    @Override
    public String myRecommender(String recommenderNo) {
        logger.info("Method myRecommender start recmNo:{}",recommenderNo);
        ReturnBean<Recommender> returnBean = new ReturnBean<Recommender>();

        if(StringUtils.isBlank(recommenderNo)){
            returnBean.setCode(ReturnCode.FAIL);
            returnBean.setMsg("请输入合伙人编号");
        }else{
            try {
                Recommender recommender = recommenderMapper.findRecm(recommenderNo);
                logger.info("Method myRecommender sql 返回对象："+JSON.toJSONString(recommender));
                returnBean.setCode(ReturnCode.SUCCESS);
                returnBean.setMsg(ReturnCode.SUCCESS_DESC);
                returnBean.setData(recommender);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("Method myRecommender error:{}",e);
                returnBean.setCode(ReturnCode.ERROR);
                returnBean.setMsg(ReturnCode.ERROR_DESC);
            }
        }
        return JSON.toJSONString(returnBean);
    }
}
