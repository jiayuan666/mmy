package com.zjy.mmy.mapper;

import com.zjy.mmy.domain.pojo.Image;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImageMapper {
    int addList(List<Image> list);
    List<Integer> getByGoodID(int goodID);
}
