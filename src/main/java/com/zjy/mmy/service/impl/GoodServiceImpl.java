package com.zjy.mmy.service.impl;

import com.zjy.mmy.controller.request.SearchGoodRequest;
import com.zjy.mmy.mapper.GoodMapper;
import com.zjy.mmy.domain.pojo.Good;
import com.zjy.mmy.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class GoodServiceImpl implements GoodService {

    private GoodMapper goodMapper;

    @Autowired
    public GoodServiceImpl(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    @Override
    public int add(Good good) {
        int result;
        result = goodMapper.add(good);
        if(0 == result) {
            log.info("insert 0 row");
            return 0;
        }
        return good.getGoodID();
    }

    @Override
    public int delete(int goodID) {
        Good deleted = goodMapper.getByID(goodID);
        if(deleted == null) {
            log.warn("good doesn't exsit");
            return 0;
        }
        return goodMapper.delete(goodID);
    }

    @Override
    public Good getByID(int goodID) {
        return goodMapper.getByID(goodID);
    }

    @Override
    public int update(Good good) {
        Good update = goodMapper.getByID(good.getGoodID());
        if(update == null) {
            log.warn("can't find good:{}",good);
            return 0;
        }
        return goodMapper.update(good);
    }

    @Override
    public List<Good> getAll() {

        return goodMapper.getAll();
    }

    @Override
    public List<Good> getList(Good good) {
        return goodMapper.getList(good);

    }

    @Override
    public List<Good> getByUser(int id) {
        return goodMapper.getByUser(id);
    }

    @Override
    public List<Good> search(SearchGoodRequest request) {
        if (request.getPriceLt() != null && request.getPriceMt() != null
            && request.getPriceMt() > request.getPriceLt()) {
            log.warn("price range illegal");
            return null;
        }
        return goodMapper.searchGoods(request);
    }
}
