package com.lefu.service.dao;

import com.lefu.model.entity.CustomerFee;

public interface CustomerFeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_fee
     *
     * @mbggenerated Tue Apr 18 14:06:40 CST 2017
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_fee
     *
     * @mbggenerated Tue Apr 18 14:06:40 CST 2017
     */
    int insert(CustomerFee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_fee
     *
     * @mbggenerated Tue Apr 18 14:06:40 CST 2017
     */
    int insertSelective(CustomerFee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_fee
     *
     * @mbggenerated Tue Apr 18 14:06:40 CST 2017
     */
    CustomerFee selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_fee
     *
     * @mbggenerated Tue Apr 18 14:06:40 CST 2017
     */
    int updateByPrimaryKeySelective(CustomerFee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_fee
     *
     * @mbggenerated Tue Apr 18 14:06:40 CST 2017
     */
    int updateByPrimaryKey(CustomerFee record);
}