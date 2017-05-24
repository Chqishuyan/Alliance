package com.lefu.service.dao;

import com.lefu.model.entity.OperatorRecommender;

public interface OperatorRecommenderMapper {


    OperatorRecommender findByUsername(String username);
}