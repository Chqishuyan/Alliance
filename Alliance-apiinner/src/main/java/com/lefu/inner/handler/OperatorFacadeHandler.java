package com.lefu.inner.handler;

import com.lefu.inner.dubbo.OperatorFacade;
import com.lefu.model.entity.Operator;

import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/21.
 */
public abstract class OperatorFacadeHandler implements OperatorFacade{
    @Override
    public Map<String,Object> login(String username, String password) {
        return null;
    }
}

