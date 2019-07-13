package com.zjy.mmy.service;

import com.zjy.mmy.domain.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    public List<Category> getAll();
}
