package com.lefu.service.dubbo;

import com.lefu.inner.handler.OperatorFacadeHandler;
import com.lefu.model.entity.Operator;
import com.lefu.service.service.OperatorService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by shuyan.qi on 2017/4/21.
 */
@Component("operatorFacade")
public class OperatorFacadeImpl extends OperatorFacadeHandler {
    @Resource
    private OperatorService operatorService;

    @Override
    public Map<String,Object> login(String username, String password) {
        return operatorService.login(username,password);
    }
}
