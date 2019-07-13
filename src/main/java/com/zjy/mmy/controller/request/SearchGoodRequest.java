package com.zjy.mmy.controller.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchGoodRequest {
    private String nameLike;
    private Integer categoryID;
    private Integer priceLt;
    private Integer priceMt;
    private List<String> trades;
}
