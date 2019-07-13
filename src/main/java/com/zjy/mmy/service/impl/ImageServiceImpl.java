package com.zjy.mmy.service.impl;

import com.zjy.mmy.domain.pojo.Image;
import com.zjy.mmy.mapper.ImageMapper;
import com.zjy.mmy.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private ImageMapper imageMapper;
    @Autowired
    public ImageServiceImpl(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public int addList(List<Image> list) {
        return imageMapper.addList(list);
    }

    @Override
    public List<Integer> getByGood(Integer goodID) {
        return imageMapper.getByGoodID(goodID);
    }
}
