package com.zjy.mmy.controller.request;

import com.zjy.mmy.domain.OrderState;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private Integer orderID;
    private OrderState orderState;
    private Timestamp finishDate;
}
