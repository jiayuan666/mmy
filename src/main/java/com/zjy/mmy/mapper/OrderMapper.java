package com.zjy.mmy.mapper;

import com.zjy.mmy.domain.OrderState;
import com.zjy.mmy.domain.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    int add(Order order);
    int delete(Integer orderID);
    Order getByID(Integer orderID);
    int update(Order order);
    List<Order> getByUser(@Param("userID") int userID, @Param("orderState") OrderState orderState);
}
