package com.lefu.inner.dubbo;

import com.lefu.model.entity.Operator;

import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/21.
 */
public interface OperatorFacade {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Map<String,Object> login(String username, String password);
}
