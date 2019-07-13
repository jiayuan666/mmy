package com.zjy.mmy.service.impl;

import com.zjy.mmy.domain.OrderState;
import com.zjy.mmy.domain.pojo.Good;
import com.zjy.mmy.mapper.GoodMapper;
import com.zjy.mmy.mapper.OrderMapper;
import com.zjy.mmy.domain.pojo.Order;
import com.zjy.mmy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private OrderMapper orderMapper;
    private GoodMapper goodMapper;

    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, GoodMapper goodMapper) {
        this.orderMapper = orderMapper;
        this.goodMapper = goodMapper;
    }

    @Override
    public int add(Order order) throws RuntimeException {
        Good good = goodMapper.getByID(order.getGood().getGoodID());
        if(good == null) {
            log.warn("good doesn't exist");
            throw new RuntimeException("good doesn't exist");
        } else if(good.getStock() <= 0) {
            log.warn("good stock less than 1");
            throw new RuntimeException("good stock less than 1");
        }
        order.setOrderState(OrderState.UNACCEPTED);
        if(0 == orderMapper.add(order)) {
            log.info("0 row insert");
        }
        return order.getOrderID();
    }

    @Override
    public int delete(int orderID) {
        return orderMapper.delete(orderID);
    }

    @Override
    public Order getByID(int orderID) {
        return orderMapper.getByID(orderID);
    }

    @Override
    public int update(Order order) {
        Order found = orderMapper.getByID(order.getOrderID());
        if(found == null) {
            log.warn("order doesn't exist");
            throw new IllegalArgumentException("order doesn't exist");
        } else if(found.getOrderState().getValue() > order.getOrderState().getValue()) {
            log.warn("order state can not roll back");
            throw new IllegalArgumentException("order state can not roll back");
        }
        if(order.getOrderState().getValue() == OrderState.CANCELED_BY_C.getValue() ||
                order.getOrderState().getValue() == OrderState.CANCELED_BY_O.getValue() ||
                order.getOrderState().getValue() == OrderState.COMPLETED.getValue() ||
                order.getOrderState().getValue() == OrderState.FAILED.getValue()) {
            order.setFinishedDate(new Timestamp(new Date().getTime()));
        }
        return orderMapper.update(order);
    }

    @Override
    public List<Order> getByUser(Integer userID, OrderState orderState) {
        if(userID == null){
            log.warn("userID can't be null");
            throw new IllegalArgumentException("userID can't be null");
        }
        if(orderState == null) {
            orderState = OrderState.ALL;
        }
        return orderMapper.getByUser(userID, orderState);
    }

}
