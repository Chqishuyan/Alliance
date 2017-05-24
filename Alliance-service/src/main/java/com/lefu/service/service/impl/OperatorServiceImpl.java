package com.lefu.service.service.impl;

import com.lefu.model.entity.Operator;
import com.lefu.model.utils.DigestUtil;
import com.lefu.service.dao.OperatorMapper;
import com.lefu.service.service.OperatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/21.
 */
@Service
public class OperatorServiceImpl implements OperatorService {
    private Logger logger = LoggerFactory.getLogger(OperatorServiceImpl.class);

    @Resource
    private OperatorMapper operatorMapper;

    @Override
    public Map<String,Object> login(String username, String password) {
        Map<String, Object> returnMap = new HashMap<String,Object>();

        //验证用户名或密码是否正确
        String md5Pwd = DigestUtil.getMd5Str(password);
        Operator loginOperator = operatorMapper.checkLogin(username,md5Pwd);

        //成功
        if(loginOperator != null){
            //生成loginKey
            String loginKey = DigestUtil.getMd5Str(String.valueOf(System.currentTimeMillis())+username);

            //记录登录历史，保存loginKey


            //loginKey存入redis并返回
            returnMap.put("loginkey",loginKey);
        }else{
            //失败
            returnMap.put("errorMsg","用户名或密码不正确");
            return returnMap;
        }


        return returnMap;
    }
}
