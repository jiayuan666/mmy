package com.zjy.mmy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum OrderState {
    ALL(0,"所有"),
    UNACCEPTED(1,"未确认"),
    ACCEPTED(2,"卖家确认"),
    CANCELED_BY_C(3,"买家取消"),
    CANCELED_BY_O(4,"卖家取消"),
    COMPLETED(5,"交易完成"),
    FAILED(6,"交易失败");
    private int value;
    private String desc;

}
