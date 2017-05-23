package com.lefu.service.dao;

import com.lefu.model.entity.Recommender;

public interface RecommenderMapper {

    Recommender findRecm(String recommenderNo);
}