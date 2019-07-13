package com.zjy.mmy.mapper;

import com.zjy.mmy.domain.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Category> getAll();
    Category getByID();
}
