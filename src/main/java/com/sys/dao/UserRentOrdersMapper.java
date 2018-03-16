package com.sys.dao;

import com.sys.model.UserRentOrders;

public interface UserRentOrdersMapper {
	int deleteByPrimaryKey(String orderid);

	int insert(UserRentOrders record);

	int insertSelective(UserRentOrders record);

	UserRentOrders selectByPrimaryKey(String orderid);

	int updateByPrimaryKeySelective(UserRentOrders record);

	int updateByPrimaryKey(UserRentOrders record);
}