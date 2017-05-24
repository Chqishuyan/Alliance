package com.lefu.inner.handler;

import com.lefu.inner.dubbo.RecommenderFacade;
import com.lefu.model.bean.ReturnBean;

import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/18.
 */
public abstract class RecommenderHandler implements RecommenderFacade {

    @Override
    public String myRecommender(String recommenderNo) {
        return null;
    }
}
