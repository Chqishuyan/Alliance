package com.lefu.service.dao;

import com.lefu.model.entity.Operator;
import org.apache.ibatis.annotations.Param;

public interface OperatorMapper {

    Operator checkLogin(@Param("username") String username, @Param("password") String md5Pwd);
}