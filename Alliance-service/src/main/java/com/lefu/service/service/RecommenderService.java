package com.lefu.service.service;

import com.lefu.model.bean.ReturnBean;

import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/18.
 */
public interface RecommenderService {
    /**
     * 查询我的信息
     * @param recommenderNo
     * @return
     */
    String myRecommender(String recommenderNo);
}
