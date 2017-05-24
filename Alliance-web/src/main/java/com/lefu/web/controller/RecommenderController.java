package com.lefu.web.controller;

import com.alibaba.fastjson.JSON;
import com.lefu.inner.dubbo.RecommenderFacade;
import com.lefu.model.bean.ReturnBean;
import com.lefu.model.constant.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/18.
 */
@Controller
@RequestMapping("/recommender")
public class RecommenderController {
    private Logger logger = LoggerFactory.getLogger(RecommenderController.class);

    @Resource
    private RecommenderFacade recommenderFacade;

    @RequestMapping("/myRecm")
    @ResponseBody
    public String myRecommender(String recommenderNo){
        logger.info("Method myRecommender start recmNo:{}",recommenderNo);
        String result = null;
        try {
            result = recommenderFacade.myRecommender(recommenderNo);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Method myRecommender dubbo error:{}",e);
            return JSON.toJSONString(new ReturnBean<String>(ReturnCode.ERROR,ReturnCode.ERROR_DESC));
        }
        return result;
    }
}
