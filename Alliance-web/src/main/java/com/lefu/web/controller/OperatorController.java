package com.lefu.web.controller;

import com.alibaba.fastjson.JSON;
import com.lefu.inner.dubbo.OperatorFacade;
import com.lefu.model.entity.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/21.
 */
@Controller
@RequestMapping("/operator")
public class OperatorController {
    private Logger logger = LoggerFactory.getLogger(OperatorController.class);

    @Resource
    private OperatorFacade operatorFacade;

    @RequestMapping("/register")
    public String register(){
        return null;
    }

    @RequestMapping("/login")
    public String login(String username,String password, ModelAndView model, HttpServletRequest request){
        logger.info("Method login start username:{}", username);
        String loginKey = "";
        try {
            Map<String,Object> returnMap = operatorFacade.login(username,password);
            request.getSession().setAttribute("loginKey",returnMap.get("loginKey"));
            model.addObject("errorMsg",returnMap.get("errorMsg"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Method login dubbo error:{}",e);
            model.addObject("errorMsg","服务器异常，登录失败！");
        }

        return "homePage";
    }
}
