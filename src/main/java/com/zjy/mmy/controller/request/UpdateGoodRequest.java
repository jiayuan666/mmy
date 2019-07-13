package com.zjy.mmy.controller.request;

import com.zjy.mmy.domain.pojo.Category;
import com.zjy.mmy.domain.pojo.Good;
import com.zjy.mmy.domain.pojo.User;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateGoodRequest {
    @NotNull
    private Integer goodID;
    private String goodName;
    private BigDecimal price;
    private Integer stock;
    private String detail;
    private List<String> trades;
    private Integer categoryID;

    public Good toGood() {
        Good good = new Good();
        if(goodID != null) {
            good.setGoodID(goodID);
        }
        if(goodName != null) {
            good.setGoodName(goodName);
        }
        if(price != null) {
            good.setPrice(price);
        }
        if(stock != null) {
            good.setStock(stock);
        }
        if(detail != null) {
            good.setDetail(detail);
        }
        if(trades != null) {
            good.setTrades(trades);
        }
        if(categoryID != null) {
            good.setCategory(new Category(categoryID, null));
        }
        return good;
    }
}
