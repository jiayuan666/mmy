package com.zjy.mmy.service.impl;

import com.zjy.mmy.domain.pojo.Category;
import com.zjy.mmy.mapper.CategoryMapper;
import com.zjy.mmy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }
}
