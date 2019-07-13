package com.zjy.mmy.service;

import com.zjy.mmy.controller.request.SearchGoodRequest;
import com.zjy.mmy.domain.pojo.Good;

import java.util.List;


public interface GoodService {

    int add(Good good);

    int delete(int goodID);

    int update(Good good);

    Good getByID(int goodID);

    List<Good> getAll();

    List<Good> getList(Good good);

    List<Good> getByUser(int userID);

    List<Good> search(SearchGoodRequest request);
}
