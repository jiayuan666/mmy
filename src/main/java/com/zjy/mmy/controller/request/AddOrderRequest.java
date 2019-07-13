package com.zjy.mmy.controller.request;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {
    private Integer userID;
    private Integer goodID;
    private String addr;
    private String trade;
}
