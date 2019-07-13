package com.zjy.mmy.controller.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddGoodRequest {
    @NotEmpty
    public String goodName;
    @NotNull
    public Integer userID;
    @NotNull
    public BigDecimal price;
    @NotNull
    public Integer stock;
    @NotEmpty
    public String detail;
    @NotNull
    public List<String> trades;
    @NotNull
    public Integer categoryID;
}
