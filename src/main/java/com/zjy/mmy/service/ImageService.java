package com.zjy.mmy.service;

import com.zjy.mmy.domain.pojo.Image;

import java.util.List;

public interface ImageService {

    int addList(List<Image> list);
    List<Integer> getByGood(Integer goodID);
}
