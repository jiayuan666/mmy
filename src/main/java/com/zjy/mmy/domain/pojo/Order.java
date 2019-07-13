package com.zjy.mmy.domain.pojo;

import com.zjy.mmy.domain.OrderState;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * `order_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
 *   `user_id` int(10) NOT NULL,
 *   `good_id` int(10) unsigned zerofill NOT NULL,
 *   `order_state` varchar(1) NOT NULL,
 *   `created_date` timestamp,
 *   `trade` varchar(255) NOT NULL,
 *   `addr` varchar(255)NOT NULL,
 *   `finished_date` timestamp NULL,
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class Order {

    private Integer orderID;
    private User user;
    private Good good;
    private OrderState orderState;
    private Timestamp finishedDate;
    private Timestamp createdDate;
    private String addr;
    private String trade;

//    public int getOrderState() {
//        return orderState.getValue();
//    }
//    public void setOrderState(OrderState orderState) {
//        this.orderState = orderState;
//    }
//    public void setOrderState(int value) {
//        for(OrderState orderState: OrderState.values()) {
//            if(orderState.getValue() == value) {
//                this.orderState = orderState;
//                break;
//            }
//        }
//    }
//    public void setOrderState(String des) {
//        for(OrderState orderState: OrderState.values()) {
//            if(orderState.getDesc().equals(des)) {
//                this.orderState = orderState;
//                break;
//            }
//        }
//    }

}
