package com.lefu.web.interceptor;

import com.lefu.model.constant.LoginKeyConstants;
import com.lefu.model.constant.ReturnCode;
import com.lefu.web.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**登陆拦截器
 * Created by shuyan.qi on 2017/5/24.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private static String loginUrl = "/recommender/login?error="+ReturnCode.LOGIN_FAIL;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginKey = request.getParameter("loginKey");
        boolean flag = true;

        if(StringUtils.isBlank(loginKey)){
            flag  = false;
        }else{
            String userName = RedisUtil.get(LoginKeyConstants.PREFIX_USERNAME + loginKey);
            if (StringUtils.isBlank(userName)) {
                String loginKeyCache = RedisUtil.get(LoginKeyConstants.PREFIX_LOGINKEY + userName);
                if(loginKey.equals(loginKeyCache)){
                    flag  = true;
                }else{
                    logger.info("loginKey:{} 已失效");
                    flag  = false;
                }
            }else{
                logger.info("loginKey:{} 无法获取userName",loginKey);
                flag  = false;
            }
        }

        if(!flag){
            response.sendRedirect(request.getContextPath()+loginUrl);
        }
        return flag;
    }
}
