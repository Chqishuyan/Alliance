package com.lefu.service.dubbo;

import com.lefu.inner.handler.RecommenderHandler;
import com.lefu.service.service.RecommenderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by shuyan.qi on 2017/4/18.
 */
@Component("recommenderFacade")
public class RecommenderFacadeImpl extends RecommenderHandler {

    @Resource
    private RecommenderService recommenderService;

    @Override
    public String myRecommender(String recommenderNo) {
        return recommenderService.myRecommender(recommenderNo);
    }
}
