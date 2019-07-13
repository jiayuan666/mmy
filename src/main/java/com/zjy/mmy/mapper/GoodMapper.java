package com.zjy.mmy.mapper;

import com.zjy.mmy.controller.request.SearchGoodRequest;
import com.zjy.mmy.domain.pojo.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {

    int add(Good good);
    int delete(Integer goodID);
    Good getByID(Integer goodID);
    int update(Good good);
    List<Good> getAll();
    List<Good> getList(Good good);
    List<Good> getByUser(int id);
    List<Good> searchGoods(SearchGoodRequest request);
}
