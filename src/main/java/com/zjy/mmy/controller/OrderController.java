package com.zjy.mmy.controller;

import com.zjy.mmy.controller.request.AddOrderRequest;
import com.zjy.mmy.controller.request.UpdateOrderRequest;
import com.zjy.mmy.domain.OrderState;
import com.zjy.mmy.domain.pojo.Good;
import com.zjy.mmy.domain.pojo.Order;
import com.zjy.mmy.domain.pojo.User;
import com.zjy.mmy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //添加订单
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public int addOrder(@RequestBody AddOrderRequest aor) throws RuntimeException {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Order order = Order.builder()
                .good(Good.builder().goodID(aor.getGoodID()).build())
                .user(User.builder().userID(aor.getUserID()).build())
                .addr(aor.getAddr())
                .trade(aor.getTrade())
                .createdDate(timestamp)
                .build();
        return orderService.add(order);
    }

    //更新订单状态
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public int update(@RequestBody UpdateOrderRequest uor) {
        Order order = Order.builder()
                .orderID(uor.getOrderID())
                .orderState(uor.getOrderState())
                .build();
        return orderService.update(order);
    }

    //获取用户订单
    @RequestMapping(value = "getByUser", method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getByUser(@RequestParam Integer userID,
                                 @RequestParam(required = false) OrderState orderState) {
        return orderService.getByUser(userID, orderState);
    }

    //获取订单
    @RequestMapping(value = "getByID", method = RequestMethod.GET)
    @ResponseBody
    public Order getByID(@RequestParam Integer orderID) {
        return orderService.getByID(orderID);
    }
}
