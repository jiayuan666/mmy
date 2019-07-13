package com.zjy.mmy.service;

import com.zjy.mmy.domain.OrderState;
import com.zjy.mmy.domain.pojo.Order;

import javax.xml.bind.ValidationException;
import java.util.List;

public interface OrderService {

    int add(Order order) throws RuntimeException;

    int delete(int orderID);

    Order getByID(int orderID);

    int update(Order order);

    List<Order> getByUser(Integer userID, OrderState orderState);

}
